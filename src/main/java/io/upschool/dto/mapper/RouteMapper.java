package io.upschool.dto.mapper;

import io.upschool.dto.response.RouteResponse;
import io.upschool.entity.Route;
import org.mapstruct.Mapper;

@Mapper(implementationName = "RouteMapperImpl", componentModel = "spring")
public interface RouteMapper {

    RouteResponse toRouteResponse(Route route);

}
