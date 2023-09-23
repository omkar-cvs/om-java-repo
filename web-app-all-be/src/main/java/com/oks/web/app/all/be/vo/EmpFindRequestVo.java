package com.oks.web.app.all.be.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpFindRequestVo {
	@NotNull(message = "Employee Id is required")
	@PositiveOrZero(message = "Number should be positive or zero")
	private Long id;
}
