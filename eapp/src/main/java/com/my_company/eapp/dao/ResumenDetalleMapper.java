package com.my_company.eapp.dao;

import com.my_company.eapp.model.ResumenDetalle;
import com.my_company.eapp.model.ResumenDetalleExample;
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
public interface ResumenDetalleMapper {
    @SelectProvider(type=ResumenDetalleSqlProvider.class, method="countByExample")
    long countByExample(ResumenDetalleExample example);

    @DeleteProvider(type=ResumenDetalleSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResumenDetalleExample example);

    @Delete({
        "delete from resumen_detalle",
        "where id_resumen_detalle = #{idResumenDetalle,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long idResumenDetalle);

    @Insert({
        "insert into resumen_detalle (id_palabra_frase, correcto, ",
        "id_resumen)",
        "values (#{idPalabraFrase,jdbcType=INTEGER}, #{correcto,jdbcType=BIT}, ",
        "#{idResumen,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idResumenDetalle")
    int insert(ResumenDetalle row);

    @InsertProvider(type=ResumenDetalleSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idResumenDetalle")
    int insertSelective(ResumenDetalle row);

    @SelectProvider(type=ResumenDetalleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_resumen_detalle", property="idResumenDetalle", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER),
        @Result(column="correcto", property="correcto", jdbcType=JdbcType.BIT),
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER)
    })
    List<ResumenDetalle> selectByExample(ResumenDetalleExample example);

    @Select({
        "select",
        "id_resumen_detalle, id_palabra_frase, correcto, id_resumen",
        "from resumen_detalle",
        "where id_resumen_detalle = #{idResumenDetalle,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id_resumen_detalle", property="idResumenDetalle", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER),
        @Result(column="correcto", property="correcto", jdbcType=JdbcType.BIT),
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER)
    })
    ResumenDetalle selectByPrimaryKey(Long idResumenDetalle);

    @UpdateProvider(type=ResumenDetalleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") ResumenDetalle row, @Param("example") ResumenDetalleExample example);

    @UpdateProvider(type=ResumenDetalleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") ResumenDetalle row, @Param("example") ResumenDetalleExample example);

    @UpdateProvider(type=ResumenDetalleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResumenDetalle row);

    @Update({
        "update resumen_detalle",
        "set id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER},",
          "correcto = #{correcto,jdbcType=BIT},",
          "id_resumen = #{idResumen,jdbcType=INTEGER}",
        "where id_resumen_detalle = #{idResumenDetalle,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ResumenDetalle row);
    
    @SelectProvider(type=ResumenDetalleSqlProvider.class, method="selectByIdResumen")
    @Results({
        @Result(column="id_resumen_detalle", property="idResumenDetalle", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER),
        @Result(column="correcto", property="correcto", jdbcType=JdbcType.BIT),
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER)
    })
    List<ResumenDetalle> selectByIdResumen(Integer idResumen);
}