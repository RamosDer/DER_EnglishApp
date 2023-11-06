package com.my_company.eapp.dao;

import com.my_company.eapp.model.Categoria;
import com.my_company.eapp.model.CategoriaExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface CategoriaMapper {
    @SelectProvider(type=CategoriaSqlProvider.class, method="countByExample")
    long countByExample(CategoriaExample example);

    @DeleteProvider(type=CategoriaSqlProvider.class, method="deleteByExample")
    int deleteByExample(CategoriaExample example);

    @Delete({
        "delete from categoria",
        "where id_categoria = #{idCategoria,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idCategoria);

    @Insert({
        "insert into categoria (descripcion)",
        "values (#{descripcion,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idCategoria")
    int insert(Categoria row);

    @InsertProvider(type=CategoriaSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idCategoria")
    int insertSelective(Categoria row);

    @SelectProvider(type=CategoriaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_categoria", property="idCategoria", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR)
    })
    List<Categoria> selectByExample(CategoriaExample example);

    @Select({
        "select",
        "id_categoria, descripcion",
        "from categoria",
        "where id_categoria = #{idCategoria,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_categoria", property="idCategoria", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR)
    })
    Categoria selectByPrimaryKey(Integer idCategoria);

    @UpdateProvider(type=CategoriaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Categoria row, @Param("example") CategoriaExample example);

    @UpdateProvider(type=CategoriaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") Categoria row, @Param("example") CategoriaExample example);

    @UpdateProvider(type=CategoriaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Categoria row);

    @Update({
        "update categoria",
        "set descripcion = #{descripcion,jdbcType=VARCHAR}",
        "where id_categoria = #{idCategoria,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Categoria row);
}
