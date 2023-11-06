package com.my_company.eapp.dao;

import com.my_company.eapp.model.Practica;
import com.my_company.eapp.model.PracticaExample;
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
public interface PracticaMapper {

    @SelectProvider(type = PracticaSqlProvider.class, method = "countByExample")
    long countByExample(PracticaExample example);

    @DeleteProvider(type = PracticaSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PracticaExample example);

    @Delete({
        "delete from practica",
        "where id_practica = #{idPractica,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idPractica);

    @Insert({
        "insert into practica (ultima_fecha, conteo, ",
        "id_palabra_frase)",
        "values (#{ultimaFecha,jdbcType=DATE}, #{conteo,jdbcType=INTEGER}, ",
        "#{idPalabraFrase,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "idPractica")
    int insert(Practica row);

    @InsertProvider(type = PracticaSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "idPractica")
    int insertSelective(Practica row);

    @SelectProvider(type = PracticaSqlProvider.class, method = "selectByExample")
    @Results({
        @Result(column = "id_practica", property = "idPractica", jdbcType = JdbcType.INTEGER, id = true),
        @Result(column = "ultima_fecha", property = "ultimaFecha", jdbcType = JdbcType.DATE),
        @Result(column = "conteo", property = "conteo", jdbcType = JdbcType.INTEGER),
        @Result(column = "id_palabra_frase", property = "idPalabraFrase", jdbcType = JdbcType.INTEGER)
    })
    List<Practica> selectByExample(PracticaExample example);

    @Select({
        "select",
        "id_practica, ultima_fecha, conteo, id_palabra_frase",
        "from practica",
        "where id_practica = #{idPractica,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column = "id_practica", property = "idPractica", jdbcType = JdbcType.INTEGER, id = true),
        @Result(column = "ultima_fecha", property = "ultimaFecha", jdbcType = JdbcType.DATE),
        @Result(column = "conteo", property = "conteo", jdbcType = JdbcType.INTEGER),
        @Result(column = "id_palabra_frase", property = "idPalabraFrase", jdbcType = JdbcType.INTEGER)
    })
    Practica selectByPrimaryKey(Integer idPractica);

    @UpdateProvider(type = PracticaSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Practica row, @Param("example") PracticaExample example);

    @UpdateProvider(type = PracticaSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("row") Practica row, @Param("example") PracticaExample example);

    @UpdateProvider(type = PracticaSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Practica row);

    @Update({
        "update practica",
        "set ultima_fecha = #{ultimaFecha,jdbcType=DATE},",
        "conteo = #{conteo,jdbcType=INTEGER},",
        "id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}",
        "where id_practica = #{idPractica,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Practica row);
    
    @SelectProvider(type = PracticaSqlProvider.class, method = "selectByIdPalabra")
    @Results({
        @Result(column = "id_practica", property = "idPractica", jdbcType = JdbcType.INTEGER, id = true),
        @Result(column = "ultima_fecha", property = "ultimaFecha", jdbcType = JdbcType.DATE),
        @Result(column = "conteo", property = "conteo", jdbcType = JdbcType.INTEGER),
        @Result(column = "id_palabra_frase", property = "idPalabraFrase", jdbcType = JdbcType.INTEGER)
    })
    Practica selectByIdPalabra(Integer idPalabraFrase);
}
