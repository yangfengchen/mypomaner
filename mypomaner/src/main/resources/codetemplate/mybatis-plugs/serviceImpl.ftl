package ${classPath!}.service;


import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${classPath!}.entity.${className!};
import ${classPath!}.mapper.${className!}Mapper;
import ${classPath!}.service.${className!}Service;

/**
*
* <p>
*  ${classDes!}接口的实现
* </p>
*
* <p>
*   Copyright: ${createFileDateYear} . All rights reserved.
* </p>
* <p>
*   Company: ${createFileAuth}
* </p>
* <p>
*   CreateDate:${createFileDate}
* </p>
*
* @author ${createFileAuth}
* @history Mender:${createFileAuth}；Date:${createFileDate}；
*/
@Service
public class ${className!}ServiceImpl  extends ServiceImpl<${className!}Mapper, ${className!}> implements ${className!}Service  {

}