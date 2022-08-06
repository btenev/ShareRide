package softuni.bg.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import softuni.bg.model.dto.PublishRideDto;
import softuni.bg.model.dto.RideDetailsDto;
import softuni.bg.model.entity.RideEntity;

@Mapper(componentModel = "spring")
public interface RideMapper {
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "archived", constant = "false")
    RideEntity publishRideDtoToRideEntity(PublishRideDto publishRideDto);

    RideDetailsDto rideEntityToRideDetailsDto(RideEntity ride);
}
