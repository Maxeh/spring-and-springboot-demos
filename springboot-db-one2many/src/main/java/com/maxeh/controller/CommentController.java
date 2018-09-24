package com.maxeh.controller;

import com.maxeh.exception.ResourceNotFoundException;
import com.maxeh.model.Comment;
import com.maxeh.repository.CommentRepository;
import com.maxeh.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable Long postId, @Valid @RequestBody Comment comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable (value = "postId") Long postId,
                                 @PathVariable (value = "commentId") Long commentId,
                                 @Valid @RequestBody Comment commentRequest) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            if (comment.getPost().getId() != postId) {
                throw new ResourceNotFoundException("There is no comment with the commentId " +
                        commentId + " for the post with the postId " + postId);
            }

            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") Long postId,
                                           @PathVariable (value = "commentId") Long commentId) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            if (comment.getPost().getId() != postId) {
                throw new ResourceNotFoundException("There is no comment with the commentId " +
                        commentId + " for the post with the postId " + postId);
            }

            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + " not found"));
    }
}

