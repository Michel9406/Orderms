package tech.buildrun.orderms.controller.dto;

public record paginationResponse(Integer page,
                                 Integer pageSize,
                                 Integer totalElements,
                                 Integer totalPages) {
}
