// Source code is decompiled from a .class file using FernFlower decompiler.
public class StringArrays {
   public StringArrays() {
   }

   public static String findLongestName(String[] var0) {
      if (var0 != null && var0.length != 0) {
         String var1 = var0[0];
         String[] var2 = var0;
         int var3 = var0.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            if (var5.length() > var1.length()) {
               var1 = var5;
            }
         }

         return var1;
      } else {
         return null;
      }
   }

   public static int countNamesStartingWith(String[] var0, char var1) {
      if (var0 == null) {
         return 0;
      } else {
         int var2 = 0;
         char var3 = Character.toUpperCase(var1);
         String[] var4 = var0;
         int var5 = var0.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            if (var7 != null && !var7.isEmpty() && Character.toUpperCase(var7.charAt(0)) == var3) {
               ++var2;
            }
         }

         return var2;
      }
   }

   public static String[] formatNames(String[] var0) {
      if (var0 == null) {
         return null;
      } else {
         String[] var1 = new String[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            if (var0[var2] != null) {
               String[] var3 = var0[var2].split(" ");
               if (var3.length >= 2) {
                  var1[var2] = var3[1] + ", " + var3[0];
               } else {
                  var1[var2] = var0[var2];
               }
            }
         }

         return var1;
      }
   }

   public static void main(String[] var0) {
      String[] var1 = new String[]{"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};
      System.out.println("Longest name: " + findLongestName(var1));
      System.out.println("Names starting with 'A': " + countNamesStartingWith(var1, 'A'));
      System.out.println("Names starting with 'B': " + countNamesStartingWith(var1, 'B'));
      String[] var2 = formatNames(var1);
      System.out.println("\nFormatted names:");
      String[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         System.out.println(var6);
      }

   }
}
