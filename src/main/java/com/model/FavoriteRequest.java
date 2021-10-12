package com.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FavoriteRequest {
	private List<Restaurant> restaurants;
}
