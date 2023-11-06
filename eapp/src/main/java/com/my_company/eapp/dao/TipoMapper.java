package com.my_company.eapp.dao;

import com.my_company.eapp.model.Tipo;
import com.my_company.eapp.model.TipoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TipoMapper {

    @SelectProvider(type = TipoSqlProvider.class, method = "countByExample")
    long countByExample(TipoExample example);

    @DeleteProvider(type = TipoSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TipoExample example);

    @Delete({
        "delete from tipo",
        "where cod_tipo = #{codTipo,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String codTipo);

    @Insert({
        "insert into tipo (descripcion, fecha_registro, ",
        "id_categoria)",
        "values (#{descripcion,jdbcType=VARCHAR}, #{fechaRegistro,jdbcType=DATE}, ",
        "#{idCategoria,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "codTipo")
    int insert(Tipo row);

    @InsertProvider(type = TipoSqlProvider.class, method = "insertSelective")
    //@Options(useGeneratedKeys = true, keyProperty = "codTipo")
    int insertSelective(Tipo row);

    @SelectProvider(type = TipoSqlProvider.class, method = "selectByExample")
    @Results({
        @Result(column = "cod_tipo", property = "codTipo", jdbcType = JdbcType.VARCHAR, id = true),
        @Result(column = "descripcion", property = "descripcion", jdbcType = JdbcType.VARCHAR),
        @Result(column = "fecha_registro", property = "fechaRegistro", jdbcType = JdbcType.DATE),
        @Result(column = "id_categoria", property = "idCategoria", jdbcType = JdbcType.INTEGER)
    })
    List<Tipo> selectByExample(TipoExample example);

    @Select({
        "select",
        "cod_tipo, descripcion, fecha_registro, id_categoria",
        "from tipo",
        "where cod_tipo = #{codTipo,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column = "cod_tipo", property = "codTipo", jdbcType = JdbcType.VARCHAR, id = true),
        @Result(column = "descripcion", property = "descripcion", jdbcType = JdbcType.VARCHAR),
        @Result(column = "fecha_registro", property = "fechaRegistro", jdbcType = JdbcType.DATE),
        @Result(column = "id_categoria", property = "idCategoria", jdbcType = JdbcType.INTEGER)
    })
    Tipo selectByPrimaryKey(String codTipo);

    @UpdateProvider(type = TipoSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Tipo row, @Param("example") TipoExample example);

    @UpdateProvider(type = TipoSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("row") Tipo row, @Param("example") TipoExample example);

    @UpdateProvider(type = TipoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Tipo row);

    @Update({
        "update tipo",
        "set descripcion = #{descripcion,jdbcType=VARCHAR},",
        "fecha_registro = #{fechaRegistro,jdbcType=DATE},",
        "id_categoria = #{idCategoria,jdbcType=INTEGER}",
        "where cod_tipo = #{codTipo,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Tipo row);

    @SelectProvider(type = TipoSqlProvider.class, method = "selectByCategoria")
    @Results({
        @Result(column = "cod_tipo", property = "codTipo", jdbcType = JdbcType.VARCHAR, id = true),
        @Result(column = "descripcion", property = "descripcion", jdbcType = JdbcType.VARCHAR),
        @Result(column = "fecha_registro", property = "fechaRegistro", jdbcType = JdbcType.DATE),
        @Result(column = "id_categoria", property = "idCategoria", jdbcType = JdbcType.INTEGER)
    })
    List<Tipo> selectByCategoria(@Param("idCategoria") Integer idCategoria);
}
