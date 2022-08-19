/**
 * Classe responsável por criar, editar e deletar arquivos txt
 * @author Bruno Melo
 */
package SistemaDeAdocao.Servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dados {
    
    public static void write(String caminho, String texto) {
        try (FileWriter fw = new FileWriter(caminho, true);
                PrintWriter outPutFile = new PrintWriter(fw, true);) {
            outPutFile.println(texto);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeAgain(String caminho, String texto) {
        try (FileWriter fw = new FileWriter(caminho);
                PrintWriter outPutFile = new PrintWriter(fw, true);) {
            outPutFile.println(texto);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeNextId(String caminho) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            ArrayList<String> ids = new ArrayList<>();
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (!line.equals("")) {
                    ids.add(line);
                }
            }
            write(caminho, "" + ids.size());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeNextIdPet(String caminho) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            ArrayList<String> ids = new ArrayList<>();
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (!line.equals("")) {
                    ids.add(line);
                }
            }
            write(caminho, "" + ids.size());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int readId(String caminho) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            ArrayList<String> ids = new ArrayList<>();
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (!line.equals("")) {
                    ids.add(line);
                }
            }
            return ids.size();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return 9999;
        }
    }

    public static int readIdPet(String caminho) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            ArrayList<String> ids = new ArrayList<>();
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (!line.equals("")) {
                    ids.add(line);
                }
            }
            return ids.size();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return 9999;
        }
    }

    public static void delete(String caminho, String texto) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            String conteudoNovo = "";
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (line.contains(texto)) {
                    conteudoNovo += "";
                } else {
                    conteudoNovo += line + "\n";
                }
            }
            writeAgain(caminho, conteudoNovo);
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível apagar o usuário");
        }
    }

    public static String readLine(String caminho, String texto) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            String linhaCerta = "";
            while (scan.hasNext()) {
                String linha = scan.nextLine();
                if (linha.equals(texto)) {
                    linhaCerta = linha;
                }
            }
            return linhaCerta;
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static String readLine2(String caminho, String texto) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            String linhaCerta = "";
            while (scan.hasNext()) {
                String linha = scan.nextLine();
                if (linha.contains(texto)) {
                    linhaCerta = linha;
                }
            }
            return linhaCerta;
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static String read(String caminho) {
        File file = new File(caminho);
        try (Scanner scan = new Scanner(file);) {
            String conteudo = "";
            while (scan.hasNext()) {
                String line = scan.nextLine();
                conteudo += line + "\n";
            }
            return conteudo;
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static void deleteAll(String caminho) {
        File file = new File(caminho);
        file.delete();
    }
}
