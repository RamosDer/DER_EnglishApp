package com.my_company.eapp.dao;

import com.my_company.eapp.model.Resumen;
import com.my_company.eapp.model.ResumenExample;
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
public interface ResumenMapper {
    @SelectProvider(type=ResumenSqlProvider.class, method="countByExample")
    long countByExample(ResumenExample example);

    @DeleteProvider(type=ResumenSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResumenExample example);

    @Delete({
        "delete from resumen",
        "where id_resumen = #{idResumen,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idResumen);

    @Insert({
        "insert into resumen (tiempo, fecha_de_practica, ",
        "aciertos, palabras_practicadas, ",
        "id_usuario, id_tipo_practica)",
        "values (#{tiempo,jdbcType=INTEGER}, #{fechaDePractica,jdbcType=DATE}, ",
        "#{aciertos,jdbcType=INTEGER}, #{palabrasPracticadas,jdbcType=INTEGER}, ",
        "#{idUsuario,jdbcType=INTEGER}, #{idTipoPractica,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idResumen")
    int insert(Resumen row);

    @InsertProvider(type=ResumenSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idResumen")
    int insertSelective(Resumen row);

    @SelectProvider(type=ResumenSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tiempo", property="tiempo", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_de_practica", property="fechaDePractica", jdbcType=JdbcType.DATE),
        @Result(column="aciertos", property="aciertos", jdbcType=JdbcType.INTEGER),
        @Result(column="palabras_practicadas", property="palabrasPracticadas", jdbcType=JdbcType.INTEGER),
        @Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER),
        @Result(column="id_tipo_practica", property="idTipoPractica", jdbcType=JdbcType.INTEGER)
    })
    List<Resumen> selectByExample(ResumenExample example);

    @Select({
        "select",
        "id_resumen, tiempo, fecha_de_practica, aciertos, palabras_practicadas, id_usuario, ",
        "id_tipo_practica",
        "from resumen",
        "where id_resumen = #{idResumen,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tiempo", property="tiempo", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_de_practica", property="fechaDePractica", jdbcType=JdbcType.DATE),
        @Result(column="aciertos", property="aciertos", jdbcType=JdbcType.INTEGER),
        @Result(column="palabras_practicadas", property="palabrasPracticadas", jdbcType=JdbcType.INTEGER),
        @Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER),
        @Result(column="id_tipo_practica", property="idTipoPractica", jdbcType=JdbcType.INTEGER)
    })
    Resumen selectByPrimaryKey(Integer idResumen);

    @UpdateProvider(type=ResumenSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Resumen row, @Param("example") ResumenExample example);

    @UpdateProvider(type=ResumenSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") Resumen row, @Param("example") ResumenExample example);

    @UpdateProvider(type=ResumenSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Resumen row);

    @Update({
        "update resumen",
        "set tiempo = #{tiempo,jdbcType=INTEGER},",
          "fecha_de_practica = #{fechaDePractica,jdbcType=DATE},",
          "aciertos = #{aciertos,jdbcType=INTEGER},",
          "palabras_practicadas = #{palabrasPracticadas,jdbcType=INTEGER},",
          "id_usuario = #{idUsuario,jdbcType=INTEGER},",
          "id_tipo_practica = #{idTipoPractica,jdbcType=INTEGER}",
        "where id_resumen = #{idResumen,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Resumen row);
    
    @SelectProvider(type=ResumenSqlProvider.class, method="filterSummary")
    @Results({
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tiempo", property="tiempo", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_de_practica", property="fechaDePractica", jdbcType=JdbcType.DATE),
        @Result(column="aciertos", property="aciertos", jdbcType=JdbcType.INTEGER),
        @Result(column="palabras_practicadas", property="palabrasPracticadas", jdbcType=JdbcType.INTEGER),
        @Result(column="id_tipo_practica", property="idTipoPractica", jdbcType=JdbcType.INTEGER),
        @Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER)
    })
    Resumen getByParameters(ResumenExample example);
    
    @SelectProvider(type=ResumenSqlProvider.class, method="selectLastRecordByUser")
    @Results({
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tiempo", property="tiempo", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_de_practica", property="fechaDePractica", jdbcType=JdbcType.DATE),
        @Result(column="aciertos", property="aciertos", jdbcType=JdbcType.INTEGER),
        @Result(column="palabras_practicadas", property="palabrasPracticadas", jdbcType=JdbcType.INTEGER),
        @Result(column="id_tipo_practica", property="idTipoPractica", jdbcType=JdbcType.INTEGER),
        @Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER)
    })
    Resumen selectLastRecordByUser(Integer idUsuario);
}