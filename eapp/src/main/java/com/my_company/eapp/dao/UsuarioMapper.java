package com.my_company.eapp.dao;

import com.my_company.eapp.model.Usuario;
import com.my_company.eapp.model.UsuarioExample;
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
public interface UsuarioMapper {
    @SelectProvider(type=UsuarioSqlProvider.class, method="countByExample")
    long countByExample(UsuarioExample example);

    @DeleteProvider(type=UsuarioSqlProvider.class, method="deleteByExample")
    int deleteByExample(UsuarioExample example);

    @Delete({
        "delete from usuario",
        "where id_usuario = #{idUsuario,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idUsuario);

    @Insert({
        "insert into usuario (nombre_usuario, nombre, ",
        "apellido, fecha_registro, ",
        "contrasenha)",
        "values (#{nombreUsuario,jdbcType=VARCHAR}, #{nombre,jdbcType=VARCHAR}, ",
        "#{apellido,jdbcType=VARCHAR}, #{fechaRegistro,jdbcType=DATE}, ",
        "#{contrasenha,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idUsuario")
    int insert(Usuario row);

    @InsertProvider(type=UsuarioSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idUsuario")
    int insertSelective(Usuario row);

    @SelectProvider(type=UsuarioSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre_usuario", property="nombreUsuario", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="apellido", property="apellido", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="contrasenha", property="contrasenha", jdbcType=JdbcType.VARCHAR)
    })
    List<Usuario> selectByExample(UsuarioExample example);

    @Select({
        "select",
        "id_usuario, nombre_usuario, nombre, apellido, fecha_registro, contrasenha",
        "from usuario",
        "where id_usuario = #{idUsuario,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre_usuario", property="nombreUsuario", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="apellido", property="apellido", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="contrasenha", property="contrasenha", jdbcType=JdbcType.VARCHAR)
    })
    Usuario selectByPrimaryKey(Integer idUsuario);

    @UpdateProvider(type=UsuarioSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Usuario row, @Param("example") UsuarioExample example);

    @UpdateProvider(type=UsuarioSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") Usuario row, @Param("example") UsuarioExample example);

    @UpdateProvider(type=UsuarioSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Usuario row);

    @SelectProvider(type=UsuarioSqlProvider.class, method="doesUsernameExist")
    int doesUsernameExist(String username);

    @Update({
        "update usuario",
        "set nombre_usuario = #{nombreUsuario,jdbcType=VARCHAR},",
          "nombre = #{nombre,jdbcType=VARCHAR},",
          "apellido = #{apellido,jdbcType=VARCHAR},",
          "fecha_registro = #{fechaRegistro,jdbcType=DATE},",
          "contrasenha = #{contrasenha,jdbcType=VARCHAR}",
        "where id_usuario = #{idUsuario,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Usuario row);
    
    @Select({
        "select",
        "nombre_usuario, contrasenha", // Solo necesitamos el nombre de usuario y la contraseña
        "from usuario",
        "where nombre_usuario = #{nombreUsuario,jdbcType=VARCHAR}"
    })
    @Results({
        //@Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre_usuario", property="nombreUsuario", jdbcType=JdbcType.VARCHAR),
        //@Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        //@Result(column="apellido", property="apellido", jdbcType=JdbcType.VARCHAR),
       // @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="contrasenha", property="contrasenha", jdbcType=JdbcType.VARCHAR)
    })
    Usuario selectUsuarioByNombreUsuario(String nombreUsuario);
    
    @SelectProvider(type=UsuarioSqlProvider.class, method="getUserByUsername")
    @Results({
        @Result(column="id_usuario", property="idUsuario", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nombre_usuario", property="nombreUsuario", jdbcType=JdbcType.VARCHAR),
        @Result(column="nombre", property="nombre", jdbcType=JdbcType.VARCHAR),
        @Result(column="apellido", property="apellido", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="contrasenha", property="contrasenha", jdbcType=JdbcType.VARCHAR)
    })        
    Usuario getUserByUsername(String username);

}
