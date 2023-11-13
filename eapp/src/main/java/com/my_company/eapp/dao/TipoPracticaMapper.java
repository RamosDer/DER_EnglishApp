package com.my_company.eapp.dao;

import com.my_company.eapp.model.TipoPractica;
import com.my_company.eapp.model.TipoPracticaExample;
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
public interface TipoPracticaMapper {
    @SelectProvider(type=TipoPracticaSqlProvider.class, method="countByExample")
    long countByExample(TipoPracticaExample example);

    @DeleteProvider(type=TipoPracticaSqlProvider.class, method="deleteByExample")
    int deleteByExample(TipoPracticaExample example);

    @Delete({
        "delete from tipo_practica",
        "where id_tipo_practica = #{idTipoPractica,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idTipoPractica);

    @Insert({
        "insert into tipo_practica (tipo)",
        "values (#{tipo,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idTipoPractica")
    int insert(TipoPractica row);

    @InsertProvider(type=TipoPracticaSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idTipoPractica")
    int insertSelective(TipoPractica row);

    @SelectProvider(type=TipoPracticaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_tipo_practica", property="idTipoPractica", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tipo", property="tipo", jdbcType=JdbcType.VARCHAR)
    })
    List<TipoPractica> selectByExample(TipoPracticaExample example);

    @Select({
        "select",
        "id_tipo_practica, tipo",
        "from tipo_practica",
        "where id_tipo_practica = #{idTipoPractica,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_tipo_practica", property="idTipoPractica", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tipo", property="tipo", jdbcType=JdbcType.VARCHAR)
    })
    TipoPractica selectByPrimaryKey(Integer idTipoPractica);

    @UpdateProvider(type=TipoPracticaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") TipoPractica row, @Param("example") TipoPracticaExample example);

    @UpdateProvider(type=TipoPracticaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") TipoPractica row, @Param("example") TipoPracticaExample example);

    @UpdateProvider(type=TipoPracticaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TipoPractica row);

    @Update({
        "update tipo_practica",
        "set tipo = #{tipo,jdbcType=VARCHAR}",
        "where id_tipo_practica = #{idTipoPractica,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TipoPractica row);
}