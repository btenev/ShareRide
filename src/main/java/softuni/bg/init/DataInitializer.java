package softuni.bg.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.model.entity.RoleEntity;
import softuni.bg.model.enums.RoleEnum;
import softuni.bg.repository.RoleRepository;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.roleRepository.count() == 0) {

            Arrays.stream(RoleEnum.values())
                    .forEach(roleEnum -> {
                        RoleEntity newRole = new RoleEntity();

                        newRole.setUserRole(roleEnum);

                        this.roleRepository.save(newRole);
                    });
        }
    }
}
