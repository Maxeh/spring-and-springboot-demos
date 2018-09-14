package com.maxeh;

import com.maxeh.model.Gender;
import com.maxeh.model.User;
import com.maxeh.model.UserProfile;
import com.maxeh.repository.UserRepository;
import com.maxeh.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Calendar;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Clean up database tables
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        User user = new User("Rajeev", "Singh", "rajeev@callicoder.com", "MY_SUPER_SECRET_PASSWORD");

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);

        UserProfile userProfile = new UserProfile("+91-8197882053", Gender.MALE, dateOfBirth.getTime(),
                "747", "2nd Cross", "Golf View Road, Kodihalli", "Bangalore",
                "Karnataka", "India", "560008");

        user.setUserProfile(userProfile); // Set child reference(userProfile) in parent entity(user)
        userProfile.setUser(user); // Set parent reference(user) in child entity(userProfile)

        userRepository.save(user); // Save Parent Reference (which will save the child as well)
    }
}