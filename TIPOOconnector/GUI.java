package TIPOOconnector;

import javax.swing.*;

public class GUI {
    private static String salida = "";

    public static String getPassword(String mensaje)
    {
        boolean matchPasswords;
        JPasswordField passField = new JPasswordField();
        JPasswordField passFieldConfirm = new JPasswordField();
        JLabel label = new JLabel(String.format("%s", mensaje));
        String pass1, pass2;

        do
        {
            JOptionPane.showConfirmDialog(null, new Object[]{label, passField}, "Credenciales de Acceso", JOptionPane.OK_CANCEL_OPTION);
            JOptionPane.showConfirmDialog(null, new Object[]{label, passFieldConfirm}, "Confirma Credenciales de Acceso", JOptionPane.OK_CANCEL_OPTION);
            
            pass1 = String.valueOf(passField.getPassword());
            pass2 = String.valueOf(passFieldConfirm.getPassword());
            if (pass1.equals(pass2))
            {
                return String.valueOf(passField.getPassword());
            }
            
            JOptionPane.showMessageDialog(null, " Las claves no concuerdan - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);       

        }while(true);

    }


    public static boolean isCURP(String curpString)
    {
        return curpString.matches("[A-Z]{4}\\d{6}[H,M][A-Z]{5}\\d{2}");        
    }


   public static String getCURP(String mensaje)
   {
        String tempCurp;
        do
        {
            tempCurp = getString(mensaje);

            if (isCURP(tempCurp))
            {
                return tempCurp;
            }
             
            JOptionPane.showMessageDialog(null, tempCurp + " no es un formato CURP correcto - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            

        }while(true);
   }


   public static boolean isRFC(String rfcString)
   {
        return rfcString.matches("[A-Z]{4}\\d{6}[A-Z]{3}[-]\\d{2}");
   }

   public static String getRFC(String mensaje)
   {

        do
        {
            String tempRFC = getString(mensaje);

            if (isRFC(tempRFC))
            {
                return tempRFC;
            }
    
            JOptionPane.showMessageDialog(null, tempRFC + " no es un formato RFC correcto - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);          

        }while(true);    
   }

    
    // Método para leer una cadena. Ej. n = GUI.getString("Introduce tu nombre");
    public static String getString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }
   
    public static char getChar(String mensaje) {
        String s = JOptionPane.showInputDialog(mensaje);
      
        if (s.length() == 1)
            return s.charAt(0);
        else {
            JOptionPane.showMessageDialog(null, s + " no es un caracter - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getChar(mensaje);
        }
    }
   
    public static byte getByte(String mensaje, byte min, byte max) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            byte i = Byte.parseByte(n);
         
            if (i >= min && i <= max)
                return i;
            else {
                JOptionPane.showMessageDialog(null, i + " esta fuera del intervalo " + min + " a " + max + " - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
                return getByte(mensaje, min, max);
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un byte invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getByte(mensaje, min, max);
        }
    }

    public static byte getByte(String mensaje) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            byte i = Byte.parseByte(n);
            return i;
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un byte invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getByte(mensaje);
        }
    }


    public static int getSplitedInt(int maxLength, String mensaje)
    {
        int numero;
        String regexPattern = String.format("\\d{%d}", maxLength);
        boolean resultadoRegex;

        do
        {
            numero = getInt(mensaje, null);
            resultadoRegex = String.valueOf(numero).matches(regexPattern);
            
            if (resultadoRegex)
            {
                return numero;
            }
            
            JOptionPane.showMessageDialog(null, String.format("%d debe ser menor de %d cifras - vuelva a teclear", numero, maxLength), "Error", JOptionPane.ERROR_MESSAGE);
            

        }while(true);
    
    }//end getCuenta


    public static boolean isInt(String elemento)
    {
        try
        {
            int tempInt = Integer.parseInt(elemento);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }   

    // Método para leer un int en un intervalo. Ej. e = GUI.getInt("Introduce tu edad", 0, 100); 
    public static int getInt(String mensaje, int min, int max, String mensajeError) {               

        do
        {
            String cadenaNumero = JOptionPane.showInputDialog(mensaje);
            int numero;
          
            if (mensajeError == null)
            {
                mensajeError = " est\u00E1 fuera del intervalo " + min + " a " + max + " - vuelva a teclear";
            }

            if (isInt(cadenaNumero))
            {
                numero = Integer.parseInt(cadenaNumero);
                
                if (numero <= max && numero >= min)
                {
                    return numero;
                }

                JOptionPane.showMessageDialog(null, String.valueOf(numero) + mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            }            
            else
            {
                
                JOptionPane.showMessageDialog(null, cadenaNumero + " es un int inv\u00E1lido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);    
            }

        }while(true);

    }

    // Método para leer un int. Ej. x = GUI.getInt("Introduce un valor"); 
    public static int getInt(String mensaje, String mensajeError)
    {   
        do
        {

            String cadenaNumero = JOptionPane.showInputDialog(mensaje);
            int numero;
            
            if (mensajeError == null)
            {
                mensajeError = " es un int invalido - vuelva a teclear";
            }
        
            if (isInt(cadenaNumero))
            {
                return Integer.parseInt(cadenaNumero);
            }            
            else
            {
                JOptionPane.showMessageDialog(null, cadenaNumero + mensajeError, "Error", JOptionPane.ERROR_MESSAGE);    
            }

        }while(true);
    }//end getInt(String mensaje)


    public static short getShort(String mensaje, short min, short max) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            short i = Short.parseShort(n);
         
            if (i >= min && i <= max)
                return i;
            else {
                JOptionPane.showMessageDialog(null, i + " esta fuera del intervalo " + min + " a " + max + " - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
                return getShort(mensaje, min, max);
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un short invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getShort(mensaje, min, max);
        }
    }

    public static short getShort(String mensaje) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            short i = Short.parseShort(n);
            return i;
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un short invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getShort(mensaje);
        }
    }

    public static long getLong(String mensaje, long min, long max) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            long i = Long.parseLong(n);
         
            if (i >= min && i <= max)
                return i;
            else {
                JOptionPane.showMessageDialog(null, i + " esta fuera del intervalo " + min + " a " + max + " - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
                return getLong(mensaje, min, max);
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un long invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getLong(mensaje, min, max);
        }
    }

    public static long getLong(String mensaje) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            long i = Long.parseLong(n);
            return i;
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un long invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getLong(mensaje);
        }
    }

    // Método para leer un float en un intervalo. Ej. t = GUI.getFloat("Introduce la temperatura", -20.7, 50.6);
    public static float getFloat(String mensaje, float min, float max, String mensajeError) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        if (mensajeError == null)
        {
            mensajeError = " esta fuera del intervalo " + min + " a " + max + " - vuelva a teclear";
        }
        else
        {
            mensajeError = " esta fuera del intervalo " + min + " a " + max + " - vuelva a teclear" + mensajeError;
        }

        do{
            if (isFloat(n))
            {
                float d = (new Float(n)).floatValue();    
                    if (d >= min && d <= max)
                        return d;
            }
            
                
            JOptionPane.showMessageDialog(null, n + mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }while(true);
         
    }//end getFloat
   
    // Método para leer un float. Ej.xt = GUI.getFloat("Introduce la constante"); 
    
    public static boolean isFloat(String elemento)
    {
        try
        {
            float tempFloat = (new Float(elemento)).floatValue();
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }  

    public static float getFloat(String mensaje, String mensajeError) {
        String n = JOptionPane.showInputDialog(mensaje);
      
      if (mensajeError == null)
        {
            mensajeError = " esta fuera del intervalo - vuelva a teclear";
        }
        else
        {
            mensajeError = " esta fuera del intervalo - vuelva a teclear" + mensajeError;
        }

        do{
            if (isFloat(n))
            {
                float d = (new Float(n)).floatValue();    
                return d;
            }
            
                
            JOptionPane.showMessageDialog(null, n + mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }while(true);
    }//end getFloat

   
    public static double getDouble(String mensaje, double min, double max) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            double d = Double.parseDouble(n);
         
            if (d >= min && d <= max)
                return d;
            else {
                JOptionPane.showMessageDialog(null, d + " esta fuera del intervalo " + min + " a " + max + " - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
                return getDouble(mensaje, min, max);
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un double invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getDouble(mensaje, min, max);
        }
    }
   
    public static double getDouble(String mensaje) {
        String n = JOptionPane.showInputDialog(mensaje);
      
        try {
            double d = (new Double(n)).doubleValue();
            return d;
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, n + " es un double invalido - vuelva a teclear", "Error", JOptionPane.ERROR_MESSAGE);
            return getDouble(mensaje);
        }
    }

    // Método para leer un boolean. Ej. c = GUI.getBoolean("Quieres ir al cine?");
    public static boolean getBoolean(String pregunta) {
        int n = JOptionPane.showConfirmDialog(null, pregunta, "Responda si/no", JOptionPane.YES_NO_OPTION);

        return (n == 0);
    }
   
    // Método para leer un boolean utilizando 2 valores. Ej. s = GUI.getBoolean("Como te sientes?", "Triste", "Feliz");
    public static boolean getBoolean(String pregunta, String afirmativo, String negativo) {
        Object[] opciones = {afirmativo, negativo};

        int n = JOptionPane.showOptionDialog(null, pregunta, "Seleccione " + afirmativo + " o " + negativo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        return (n == 0);
    }
   
    // Método para leer una opción de n valores. Ej. op = GUI.getChoice("Como te sientes?", "Triste", "Feliz", "Cansado", "Enojado");
    public static int getChoice(String pregunta, String[] opciones) {
        int n = JOptionPane.showOptionDialog(null, pregunta, "Seleccione una de las opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        return n;
    }
   
    // Método para mostrar un mensaje en la pantalla. Ej. GUI.displayMessage("El resultado es" + x);
    public static void displayMessage(String mensaje) {
      JOptionPane.showMessageDialog(null, mensaje, "Resultados", JOptionPane.PLAIN_MESSAGE);
    }
   
    // Método para mostrar una alerta en la pantalla. Ej. GUI.alert("No se pudo abrir el archivo");
    public static void alert(String mensaje) {
      JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método apra mostrar en la pantalla una cadena almacenada a través del método appendOutput().
    // Ej. GUI.appendOutput("Ingenieria ");
    //     GUI.appendOutput("Computación");
    //     GUI.displayOutput();
    public static void displayOutput() {
        JTextArea areaDeSalida = new JTextArea(10, 30);
        areaDeSalida.setText(salida);
        areaDeSalida.setEditable(false);
        JScrollPane desplazamiento = new JScrollPane(areaDeSalida, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JOptionPane.showMessageDialog(null, desplazamiento, "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }
   
    public static void displayOutput(String titulo) {
        JTextArea areaDeSalida = new JTextArea(10, 30);
        areaDeSalida.setText(salida);
        areaDeSalida.setEditable(false);
        JScrollPane desplazamiento = new JScrollPane(areaDeSalida, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JOptionPane.showMessageDialog(null, desplazamiento, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void clearOutput() {
        salida = "";
    }
   
    public static void appendOutput(String siguiente) {
        salida += siguiente;
    }
   
    public static void appendOutput(char siguiente) {
        salida += siguiente;
    }
   
    public static void appendOutput(byte siguiente) {
        salida += siguiente;
    }
   
    public static void appendOutput(int siguiente) {
        salida += siguiente;
    }

    public static void appendOutput(short siguiente) {
        salida += siguiente;
    }
   
    public static void appendOutput(long siguiente) {
        salida += siguiente;
    }
   
    public static void appendOutput(float siguiente) {
        salida += siguiente;
    }
   
    public static void appendOutput(double siguiente) {
        salida += siguiente;
    }
   
    public static void appendOutput(boolean siguiente) {
        salida += siguiente;
    }   
}
