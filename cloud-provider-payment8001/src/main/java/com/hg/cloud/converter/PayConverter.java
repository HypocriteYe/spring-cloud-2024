package com.hg.cloud.converter;


import com.hg.cloud.entities.po.Pay;
import com.hg.cloud.entities.dto.PayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 14:15
 */
@Mapper(componentModel = "spring")
public interface PayConverter {

    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    Pay convert(PayDTO payDTO);

    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    PayDTO convert(Pay pay);

    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    List<PayDTO> convert(List<Pay> payList);


}
