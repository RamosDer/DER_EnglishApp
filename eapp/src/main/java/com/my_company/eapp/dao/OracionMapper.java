package com.my_company.eapp.dao;

import com.my_company.eapp.model.Oracion;
import com.my_company.eapp.model.OracionExample;
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
public interface OracionMapper {
    @SelectProvider(type=OracionSqlProvider.class, method="countByExample")
    long countByExample(OracionExample example);

    @DeleteProvider(type=OracionSqlProvider.class, method="deleteByExample")
    int deleteByExample(OracionExample example);

    @Delete({
        "delete from oracion",
        "where id_oracion = #{idOracion,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idOracion);

    @Insert({
        "insert into oracion (texto, fecha_registro, ",
        "id_palabra_frase)",
        "values (#{texto,jdbcType=VARCHAR}, #{fechaRegistro,jdbcType=DATE}, ",
        "#{idPalabraFrase,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idOracion")
    int insert(Oracion row);

    @InsertProvider(type=OracionSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idOracion")
    int insertSelective(Oracion row);

    @SelectProvider(type=OracionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_oracion", property="idOracion", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="texto", property="texto", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER)
    })
    List<Oracion> selectByExample(OracionExample example);

    @Select({
        "select",
        "id_oracion, texto, fecha_registro, id_palabra_frase",
        "from oracion",
        "where id_oracion = #{idOracion,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_oracion", property="idOracion", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="texto", property="texto", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER)
    })
    Oracion selectByPrimaryKey(Integer idOracion);

    @UpdateProvider(type=OracionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Oracion row, @Param("example") OracionExample example);

    @UpdateProvider(type=OracionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") Oracion row, @Param("example") OracionExample example);

    @UpdateProvider(type=OracionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Oracion row);

    @Update({
        "update oracion",
        "set texto = #{texto,jdbcType=VARCHAR},",
          "fecha_registro = #{fechaRegistro,jdbcType=DATE},",
          "id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}",
        "where id_oracion = #{idOracion,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Oracion row);
    
    @SelectProvider(type=OracionSqlProvider.class, method="getOracionIdByPalabraFraseId")
    @Results({
        @Result(column="id_oracion", property="idOracion", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="texto", property="texto", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER)
    })
    List<Oracion> getOracionIdByPalabraFraseId(Integer idPalabraFrase);
}
