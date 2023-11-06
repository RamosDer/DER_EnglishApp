package com.my_company.eapp.dao;

import com.my_company.eapp.model.Significado;
import com.my_company.eapp.model.SignificadoExample;
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
public interface SignificadoMapper {
    @SelectProvider(type=SignificadoSqlProvider.class, method="countByExample")
    long countByExample(SignificadoExample example);

    @DeleteProvider(type=SignificadoSqlProvider.class, method="deleteByExample")
    int deleteByExample(SignificadoExample example);

    @Delete({
        "delete from significado",
        "where id_significado = #{idSignificado,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idSignificado);

    @Insert({
        "insert into significado (descripcion, id_palabra_frase, ",
        "fecha_registro)",
        "values (#{descripcion,jdbcType=VARCHAR}, #{idPalabraFrase,jdbcType=INTEGER}, ",
        "#{fechaRegistro,jdbcType=DATE})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idSignificado")
    int insert(Significado row);

    @InsertProvider(type=SignificadoSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idSignificado")
    int insertSelective(Significado row);

    @SelectProvider(type=SignificadoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_significado", property="idSignificado", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE)
    })
    List<Significado> selectByExample(SignificadoExample example);

    @Select({
        "select",
        "id_significado, descripcion, id_palabra_frase, fecha_registro",
        "from significado",
        "where id_significado = #{idSignificado,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_significado", property="idSignificado", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE)
    })
    Significado selectByPrimaryKey(Integer idSignificado);

    @UpdateProvider(type=SignificadoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Significado row, @Param("example") SignificadoExample example);

    @UpdateProvider(type=SignificadoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") Significado row, @Param("example") SignificadoExample example);

    @UpdateProvider(type=SignificadoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Significado row);

    @Update({
        "update significado",
        "set descripcion = #{descripcion,jdbcType=VARCHAR},",
          "id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER},",
          "fecha_registro = #{fechaRegistro,jdbcType=DATE}",
        "where id_significado = #{idSignificado,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Significado row);
    
    @Select({
        "select",
        "id_significado, descripcion, id_palabra_frase, fecha_registro",
        "from significado",
        "where id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}"
        //"where id_significado = #{idSignificado,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_significado", property="idSignificado", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE)
    })
    List<Significado> selectByPalabraFrasePrimaryKey(Integer idPalabraFrase);
    
    @SelectProvider(type=SignificadoSqlProvider.class, method="findRandomDefiniciones")
    @Results({
        @Result(column="id_significado", property="idSignificado", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="descripcion", property="descripcion", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE)
    })
    List<Significado> findRandomDefiniciones(@Param("count") int count, @Param("excludePalabraFraseId") Integer excludePalabraFraseId);
    
     @SelectProvider(type = SignificadoSqlProvider.class, method = "getSignificadoIdByDescripcion")
    int getSignificadoIdByDescripcion(String descripcion);
}
