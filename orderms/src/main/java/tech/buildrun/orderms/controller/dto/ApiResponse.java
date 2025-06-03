package tech.buildrun.orderms.controller.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data, paginationResponse pagination) {
}
