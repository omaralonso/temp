package pe.com.brunominelli.util;

public class Constantes {
    
    // CONSTANTES DE BASE DE DATOS
    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_INACTIVO = 0;
    
    public static final String PERFIL_ENCARGADO_VENTAS = "VEN";
    public static final String PERFIL_ENCARGADO_ADM = "ADM";
    public static final String PERFIL_ENCARGADO_INV = "INV";
    public static final String PERFIL_CLIENTE = "CLI";
    public static final int TIPO_LIDER_DEFECTO=1;
    
    public static final String ESTADO_PEDIDO_PAGADO = "PAGADO";
    public static final String ESTADO_PEDIDO_ORDENADO = "ORDENADO";
    public static final String ESTADO_PEDIDO_CANCELADO = "CANCELADO";
    
    public static final int INICIO_PRODUCTOS_POR_PAGINA_POR_DEFECTO = 0;
    
    public static final String PARAMETRIA_PRODUCTOS_POR_PAGINA = "4";
    
    //**************************** MENSAJES ERROR *************************
    public static final String ERROR_AUTENTICACION_USERNAME = "Este usuario no existe";
    public static final String ERROR_AUTENTICACION_PASSWORD = "Contraseña errada";

    public static final String ERROR_CONTRASEÑAS_NO_COINCIDEN = "Las contraseñas no coinciden"; 
    
    public static final String ERROR_CATEGORIA_REPETIDA="La categoria ingresada ya existe";
    
    public static final String ERROR_NO_SE_ENCONTRO_CLIENTE = "No se encontro al cliente";
    public static final String ERROR_STOCK_AGOTADO = "Lo sentimos, se han agotado las unidades de %s $";
    public static final String ERROR_STOCK_INSUFICIENTE = "Lo sentimos, solo quedan %d unidades de %s $";
    
    public static final String ERROR_GENERICO_PEDIDO = "Ocurrió un error al intentar procesar el pedido";
    
    /**************************** MENSAJES DE EXITO ****************************/
    public static final String PRODUCTO_CARRITO_EXITO = "Se agregó el producto al carrito";
    
    public static final String PEDIDO_REGISTRADO_EXITO = "Se registró el pedido con éxito";
}
