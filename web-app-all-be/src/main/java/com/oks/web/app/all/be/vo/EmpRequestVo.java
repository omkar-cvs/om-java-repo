package com.oks.web.app.all.be.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpRequestVo {
	@Valid
	@NotNull(message = "EmpVo should not be null")
    private EmpVo empVo;
}
