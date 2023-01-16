package finalproyecto;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

// AUTORES :  HENRY RINCON, EDGARDO TOLEDO, ELENA  VALVERDE. //
public class Finalproyecto {

    public static void main(String[] args) throws IOException {

        // DEFINIMOS NUESTRA ENTRADA POR TECLADO.// 
        Scanner entrada = new Scanner(System.in);
        //DEFINIMOS LAS VARIABLES A UTULIZAR
        int D, OP, hora_c, hora_e;
        double base = 0;

        System.out.println("******************************************************************");
        System.out.println("***************** SOFTWARE TansCaribeColV.1.0.4  *****************".toUpperCase()); //LO CONVERTIMOS TODO EN MAYUSCULA
        System.out.println("******************************************************************");
        System.out.println("");
        System.out.println("POR FACOR INGRESAR EL NUMERO DE EMPLEADOS A REALIZAR LA OPERACIÓN :  ");
        D = Integer.parseInt(entrada.nextLine());

        //  DEFINIMMOS VECTORES. //
        String nombres[] = new String[D];
        String tipo[] = new String[D];
        String profesion[] = new String[D];
        int H_trabajadas_mes[] = new int[D];
        int salario_bruto[] = new int[D];
        int Horas_extras[] = new int[D];
        int total_Horas_mes[] = new int[D];
        int total_hora_extra[] = new int[D];

        // DEFINIMOS VECTORES PARA LOS APORTES POR LEY //
        double salud[] = new double[D];
        double pension[] = new double[D];
        double ARL[] = new double[D];
        double Total_descuento[] = new double[D];
        double total_a_pagar[] = new double[D];

        DecimalFormat convercion = new DecimalFormat("###.##"); // usamos este metodo para eliminar la parte decimal de los datos numericos. //

        for (int i = 0; i < D; i++) {

            // LE PREGUNTAMOS POR PANTALLA AL USUARIO QUE ROL VA A ESCOGER. //
            System.out.println("");
            System.out.println("*****************************************************************");
            System.out.println("POR FAVOR ELIJA EL AREA ROL DEL EMPLEADO : ");
            System.out.println("");
            System.out.println("1 ES ADMISTRATIVO |||| 2 ES OPERATIVO");
            System.out.println("*****************************************************************");
            OP = Integer.parseInt(entrada.nextLine());

            // REALIZAMOS UNA CONDICION PARA QUE EL PROGRAMA IDENTIFIQUE LOS ROLES //
            if (OP == 1) {
                //SI EL USUARIO ELIJE LA OPCION 1 ENTRARA A REALIZAR ESTE CUADRO DE CONDICIONES. //   
                tipo[i] = "Administrativo";
                profesion[i] = "Auxiliar Admin";

                System.out.println("*********************** ADMINISTRATIVOS *************************");
                System.out.println("");
                System.out.println("POR FAVOR INGRESE EL NOMBRE DEL EMPLEADO : " + (i + 1));
                nombres[i] = entrada.nextLine().toLowerCase();
                System.out.println("INGRESE HORAS CORRIENTE TRABAJADAS: ");
                hora_c = Integer.parseInt(entrada.nextLine());
                System.out.println("INGRESE HORAS EXTRAS TRABAJADAS : ");
                hora_e = Integer.parseInt(entrada.nextLine());

                // ASIGNAMOS VARIABLES A LOS VECTORES DEL ROL OPERATIVO. //
                H_trabajadas_mes[i] = hora_c;
                total_Horas_mes[i] = H_trabajadas_mes[i] * 20000;
                Horas_extras[i] = hora_e;
                total_hora_extra[i] = Horas_extras[i] * 25000;

                //CALCULAMOS EL SALARIO BRUTO Y GUARDAMOS LA INFORMACION EN EL VECTOR. //
                salario_bruto[i] = (total_Horas_mes[i] + total_hora_extra[i]);

                //REALIZAMOS LOS CALCULOS DE APORTES SEGUN EL PORCENTAJE Y GUARDAMOS LA INFORMACION EN  LOS VECTORES. // 
                salud[i] = ((salario_bruto[i] * 4) / 100);
                pension[i] = ((salario_bruto[i] * 4) / 100);
                ARL[i] = ((salario_bruto[i] * 0.522) / 100);
                Total_descuento[i] = (salud[i] + pension[i] + ARL[i]);

                //REALIZAMOS EL CALCULO PARA SABER CUANTO ES EL DESCUENTO  DEL SALARIO BRUTO MENOS EL TOTAL DESCUENTO Y LLENAMOS EL VECTOR. //
                total_a_pagar[i] = (salario_bruto[i] - Total_descuento[i]);

                //PEDIMOS INFORMACION EN EL ROL OPERATIVO. //         
                System.out.println("*****************************************************************");
                System.out.println("*********************** VOLANTE DE PAGO *************************");
                System.out.println("*****************************************************************");
                System.out.println("");
                System.out.println("NOMBRE : " + nombres[i]);
                System.out.println("CARGO : " + tipo[i]);
                System.out.println("TIPO  : " + profesion[i]);
                System.out.println("HORAS TRABAJADAS  (MES): " + H_trabajadas_mes[i]);
                System.out.println("SALARIO BRUTO : " + total_Horas_mes[i]);
                System.out.println("HORAS EXTRAS : " + Horas_extras[i]);
                System.out.println("TOTAL PAGO HORA EXTRA : " + total_hora_extra[i]);
                System.out.println("");
                // EMPEZAMOS A IMPRIMIR LOS RESULTADOS EN PANTALLA DE PARTE OPERATIVA. //
                System.out.println("***************************************************************");
                System.out.println("********************** DESCUENTOS DE LEY **********************");
                System.out.println("***************************************************************");
                System.out.println("");
                System.out.println("SALUD 4% : " + convercion.format(salud[i]));
                System.out.println("PENSION 4% : " + convercion.format(pension[i]));
                System.out.println("ARL 5% :" + convercion.format(ARL[i]));
                System.out.println("TOTAL DESCUENTO : " + convercion.format(Total_descuento[i]));
                System.out.println("TOTAL A PAGAR: " + convercion.format(total_a_pagar[i]));
                System.out.println("");
                System.out.println("**************************************************************");
                System.out.println("******************* FIN DEL VOLANTE DE PAGO ******************");
                System.out.println("**************************************************************");

                // OPERACIONES, VECTORES Y VARIABLES DE PARTE OPERATIVA. //
                // ⬇ //
            } else if (OP == 2) //SI EL USUARIO ELIJE LA OPCION 2 ENTRARA A REALIZAR ESTE CUADRO DE CONDICIONES. // 
            {
                tipo[i] = "OPERATIVO".toLowerCase(); //USAMOS ESTE COMANDO PARA CONVERTIR LA CADENA DE TEXTO EN MINUSCULA
                System.out.println("************************ OPERATIVOS **************************");
                System.out.println("");
                System.out.println(" ********************** MENU DE ROLES **************");
                System.out.println("");
                System.out.println("1 PARA CONDUCTOR || 2 PARA OFICIOS VARIOS || 3 PARA VIGILANCIA");
                int operacion = Integer.parseInt(entrada.nextLine());
                System.out.println("");
                System.out.println("POR FAVOR INGRESE EL NOMBRE DEL EMPLEADO : " + (i + 1));
                nombres[i] = entrada.nextLine().toLowerCase();

                // SE UTILIZA UN "SWITH" PARA IDENTIFICAR LOS TRES TIPOS DE ROLES OPERATIVOS. //
                switch (operacion) {
                    case 1:
                        profesion[i] = "CONDUCTOR".toLowerCase();
                        H_trabajadas_mes[i] = 160;
                        System.out.println("NO APLICA HORAS EXTRAS. ");
                        Horas_extras[i] = 0;

                        //CALCULAMOS EL SALARIO BRUTO Y GUARDAMOS LA INFORMACION EN EL VECTOR. //
                        total_Horas_mes[i] = (H_trabajadas_mes[i] * 40000);
                        salario_bruto[i] = (total_Horas_mes[i]);

                        //CALCULAMOS EL SALARIO POR LA BASE QUE EQUIBALE A EL 40% Y GUARDAMOS LA INFORMACION EN EL VECTOR. //
                        base = salario_bruto[i] * 40 / 100;

                        //REALIZAMOS LAS OPERACIONES DE DESCUENTO SEGUN LOS APORTES Y GUARDAMOS EN LOS VECTORES LA INFORMACION. //
                        salud[i] = ((base * 12.5) / 100);
                        pension[i] = ((base * 16) / 100);
                        ARL[i] = ((base * 1.44) / 100);

                        //REALIZAMOS EL CALCULO DEL DESCUENTO TOTAL  Y GUARDAMOS EN EL VECTOR. //
                        Total_descuento[i] = (salud[i] + pension[i] + ARL[i]);

                        //REALIZAMOS EL CALCULO PARA SABER CUANTO ES EL DESCUENTO  DEL SALARIO BRUTO MENOS EL TOTAL DESCUENTO Y LLENAMOS EL VECTOR. //
                        total_a_pagar[i] = (salario_bruto[i] - Total_descuento[i]);

                        // MOSTRAMOS POR PANTALLA INFORMACION DE LOS ROLES OPERATIVO. // 
                        System.out.println("***************************************************************");
                        System.out.println("*********************** VOLANTE DE PAGO ***********************");
                        System.out.println("***************************************************************");
                        System.out.println("NOMBRE : " + nombres[i]);
                        System.out.println("CARGO : " + tipo[i]);
                        System.out.println("TIPO  : " + profesion[i]);
                        System.out.println("HORAS TRABAJADAS (MES): " + H_trabajadas_mes[i]);
                        System.out.println("SALARIO BRUTO : " + total_Horas_mes[i]);
                        System.out.println("SALARIO POR BASE DE 40% : " + convercion.format(base));
                        System.out.println("HORAS EXTRAS : " + Horas_extras[i]);
                        System.out.println("TOTAL PAGO HORA EXTRA : " + Horas_extras[i]);
                        System.out.println("");
                        // IMPRIMIMOS LOS RESULTADOS DE LOS APORTES EN PANTALLA. //
                        System.out.println("***************************************************************");
                        System.out.println("********************* DESCUENTOS DE LEY ***********************");
                        System.out.println("***************************************************************");
                        System.out.println("");
                        System.out.println("SALUD 12.5% : " + convercion.format(salud[i]));
                        System.out.println("PENSION 16%:" + convercion.format(pension[i]));
                        System.out.println("ARL 1.044% :" + convercion.format(ARL[i]));
                        System.out.println("TOTAL DESCUENTO : " + convercion.format(Total_descuento[i]));
                        System.out.println("TOTAL A PAGAR : " + convercion.format(total_a_pagar[i]));
                        System.out.println("");
                        System.out.println("***************************************************************");
                        System.out.println("******************* FIN DEL VOLANTE DE PAGO *******************");
                        System.out.println("***************************************************************");
                        break;
                    case 2:
                        profesion[i] = "OFICIOS VARIOS".toLowerCase();
                        H_trabajadas_mes[i] = 100;
                        System.out.println("NO APLICA HORAS EXTRAS.");
                        Horas_extras[i] = 0;

                        //CALCULAMOS EL SALARIO BRUTO Y GUARDAMOS LA INNFORMACION EN EL VECTOR. //
                        total_Horas_mes[i] = (H_trabajadas_mes[i] * 40000);
                        salario_bruto[i] = (total_Horas_mes[i]);

                        //CALCULAMOS EL SALARIO POR LA BASE QUE EQUIBALE A EL 40% Y GUARDAMOS LA INFORMACION EN LOS VECTORES //
                        base = salario_bruto[i] * 40 / 100;

                        //REALIZAMOS LAS OPERACIONES DE DESCUENTO SEGUN LOS APORTES Y GUARDAMOS EN LOS VECTORES LA INFORMACION. //
                        salud[i] = ((base * 12.5) / 100);
                        pension[i] = ((base * 16) / 100);
                        ARL[i] = ((base * 0.522) / 100);

                        //REALIZAMOS EL CALCULO DEL DESCUENTO TOTAL  Y GUARDAMOS EN EL VECTOR. //
                        Total_descuento[i] = (salud[i] + pension[i] + ARL[i]);

                        //REALIZAMOS EL CALCULO PARA SABER CUANTO ES EL DESCUENTO  DEL SALARIO BRUTO MENOS EL TOTAL DESCUENTO Y LLENAMOS EL VECTOR. //
                        total_a_pagar[i] = (salario_bruto[i] - Total_descuento[i]);

                        //MOSTRAMOS POR PANTALLA INFORMACION DE LOS ROLES OPERATIVO. // 
                        System.out.println("**************************************************************");
                        System.out.println("*********************** VOLANTE DE PAGO **********************");
                        System.out.println("**************************************************************");
                        System.out.println("NOMBRE : " + nombres[i]);
                        System.out.println("CARGO : " + tipo[i]);
                        System.out.println("TIPO  : " + profesion[i]);
                        System.out.println("HORAS TRABAJADAS (MES): " + H_trabajadas_mes[i]);
                        System.out.println("SALARIO BRUTO : " + total_Horas_mes[i]);
                        System.out.println("SALARIO POR BASE DE 40% : " + convercion.format(base));
                        System.out.println("HORAS EXTRAS : " + Horas_extras[i]);
                        System.out.println("TOTAL PAGO HORA EXTRA : " + Horas_extras[i]);
                        System.out.println("");
                        // MOSTRAMOS POR PANTALLA LOS RESULTADOS DE LOS APORTES EN PANTALLA. // 
                        System.out.println("***************************************************************");
                        System.out.println("********************** DESCUENTOS DE LEY **********************");
                        System.out.println("***************************************************************");
                        System.out.println("");
                        System.out.println("SALUD 12% : " + convercion.format(salud[i]));
                        System.out.println("PENSION 16%:" + convercion.format(pension[i]));
                        System.out.println("ARL 5% :" + convercion.format(ARL[i]));
                        System.out.println("TOTAL DESCUENTO : " + convercion.format(Total_descuento[i]));
                        System.out.println("TOTAL A PAGAR: " + convercion.format(total_a_pagar[i]));
                        System.out.println("");
                        System.out.println("***************************************************************");
                        System.out.println("******************* FIN DEL VOLANTE DE PAGO *******************");
                        System.out.println("***************************************************************");
                        break;
                    case 3:
                        profesion[i] = "VIGILANTE".toLowerCase();
                        H_trabajadas_mes[i] = 336;
                        System.out.println("NO APLICA HORAS EXTRAS.");
                        Horas_extras[i] = 0;

                        //CALCULAMOS EL SALARIO BRUTO Y GUARDAMOS LA INNFORMACION EN EL VECTOR. //
                        total_Horas_mes[i] = (H_trabajadas_mes[i] * 40000);
                        salario_bruto[i] = (total_Horas_mes[i]);

                        //CALCULAMOS EL SALARIO POR LA BASE QUE EQUIBALE A EL 40% Y GUARDAMOS LA INFORMACION EN LOS VECTORES // 
                        base = salario_bruto[i] * 40 / 100;

                        /// REALIZAMOS LAS OPERACIONES DE DESCUENTO SEGUN LOS APORTES Y GUARDAMOS EN LOS VECTORES LA INFORMACION. //
                        salud[i] = ((base * 12.5) / 100);  // Guardamos los datos en el Vector.
                        pension[i] = ((base * 16) / 100);
                        ARL[i] = ((base * 4.350) / 100);

                        //REALIZAMOS EL CALCULO DEL DESCUENTO TOTAL  Y GUARDAMOS EN EL VECTOR. //
                        Total_descuento[i] = (salud[i] + pension[i] + ARL[i]);

                        //REALIZAMOS EL CALCULO PARA SABER CUANTO ES EL DESCUENTO  DEL SALARIO BRUTO MENOS EL TOTAL DESCUENTO Y LLENAMOS EL VECTOR. //
                        total_a_pagar[i] = (salario_bruto[i] - Total_descuento[i]);

                        // MOSTRAMOS POR PANTALLA INFORMACION DE LOS ROLES OPERATIVO. // 
                        System.out.println("**************************************************************");
                        System.out.println("********************** VOLANTE DE PAGO ***********************");
                        System.out.println("**************************************************************");
                        System.out.println("NOMBRE : " + nombres[i]);
                        System.out.println("CARGO : " + tipo[i]);
                        System.out.println("TIPO  : " + profesion[i]);
                        System.out.println("HORAS TRABAJADAS (MES): " + H_trabajadas_mes[i]);
                        System.out.println("SALARIO BRUTO : " + total_Horas_mes[i]);
                        System.out.println("SALARIO POR BASE DE 40% : " + convercion.format(base));
                        System.out.println("HORAS EXTRAS : " + Horas_extras[i]);
                        System.out.println("TOTAL PAGO HORA EXTRA : " + Horas_extras[i]);
                        System.out.println("");
                        // MOSTRAMOS POR PANTALLA LOS RESULTADOS DE LOS APORTES EN PANTALLA. //
                        System.out.println("**************************************************************");
                        System.out.println("********************* DESCUENTOS DE LEY **********************");
                        System.out.println("**************************************************************");
                        System.out.println("");
                        System.out.println("SALUD 12% : " + convercion.format(salud[i]));
                        System.out.println("PENSION 15%:" + convercion.format(pension[i]));
                        System.out.println("ARL 5% :" + convercion.format(ARL[i]));
                        System.out.println("TOTAL DESCUENTO : " + convercion.format(Total_descuento[i]));
                        System.out.println("TOTAL A PAGAR: " + convercion.format(total_a_pagar[i]));
                        System.out.println("");
                        System.out.println("**************************************************************");
                        System.out.println("****************** FIN DEL VOLANTE DE PAGO *******************");
                        System.out.println("**************************************************************");

                        break;
                    default: //EN CASO DE ERROR  EL CONDICIONAL MOSTRARA OPCION INVALIDA. //
                        System.err.println("****************** OPCION INVALIDA ***************************");
                }
            } else //EN CASO DE ELEGUIR LA OPCION INCORRECTA EL CONDICIONAL MOSTRARA OPCION INVALIDA. //
            {
                System.err.println("******************* OPCION INVALIDA **************************");
                System.out.println("**************************************************************");
            }
        }
        //IMPRIMIMOS LOS VECTORES EN PANTALLA. //
        System.out.println("Nombre           Tipo           Cargo             HT    Salario   HE    TPHE    Salud   Pension   ARL       Total a Pagar");
        for (int i = 0; i < D; i++) { //recoremos el vector.              
            System.out.println(nombres[i] + "\t" + tipo[i] + "\t" + profesion[i] + "\t  " + H_trabajadas_mes[i] + "\t" + total_Horas_mes[i] + "\t  " + Horas_extras[i] + "\t" + total_hora_extra[i] + "\t" + convercion.format(salud[i]) + "\t" + convercion.format(pension[i]) + "\t  " + convercion.format(ARL[i]) + "\t    " + convercion.format(total_a_pagar[i]));
        }
        //DEFINIMOS LA RUTA DONDE SE ALMACENARA EL TXT, SI ESTA NO SE DEFINE, MOSTRARA ERROR.// 
        FileWriter Fichero = new FileWriter("D:\\SENA\\SENA 1 TRIMEST//fichero.txt"); //FICHERO ES EL NOMBRE DEL TXT. ESTE NO SE CAMBIA

        //LE DAMOS UN POCO DE STYLO AL TXT. //
        Fichero.write("\n");
        Fichero.write("         ************************* SOFTWARE TANSCARIBECOLV.1.0.4 ***************************\n");
        Fichero.write("\n");
        Fichero.write("                               ******* FACTURACION DE NOMINA ******\n");
        Fichero.write("\n");
        Fichero.write("Nombre           Tipo           Cargo             HT    Salario   HE    TPHE    Salud   Pension   ARL       Total a Pagar \n");

        //RECORREMOS EL VECTOR PARA EXTRAER LA INFORMACION QUE ESTA ALMACENADA E IMPRIMIRLA EN UN TXT. //
        for (int i = 0; i < D; i++) {
            Fichero.write(nombres[i] + "\t" + tipo[i] + "\t" + profesion[i] + "\t  " + H_trabajadas_mes[i] + "\t" + total_Horas_mes[i] + "\t  " + Horas_extras[i] + "\t" + total_hora_extra[i] + "\t" + convercion.format(salud[i]) + "\t" + convercion.format(pension[i]) + "\t  " + convercion.format(ARL[i]) + "\t    " + convercion.format(total_a_pagar[i]) + "\n");
        }
        //CERRAMOS LA CONEXION AL TXT. //   
        Fichero.close();
    }
    // TERMINA DE COMPILAR EL PROGRAMA AQUI. //

    // GRACIAS. INGENIERO HENRY RINCON .//
}
