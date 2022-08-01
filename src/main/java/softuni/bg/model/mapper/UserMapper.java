package softuni.bg.model.mapper;

import org.mapstruct.Mapper;
import softuni.bg.model.dto.UserRegisterDto;
import softuni.bg.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userRegisterDtoToUserEntity(UserRegisterDto userRegisterDto);
}
