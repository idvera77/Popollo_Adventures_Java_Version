/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import classes.Enemigos;
import classes.Heroes;
import java.util.Scanner;

/**
 *
 * @author Mystra77
 */
public class Combate {


   public static void Batalla(Heroes heroes, Enemigos enemigos){
       
        //Sonidos Combate
        String rutaCancionVictoria = "./sonidos/Victoria.wav";
        String rutaCancionCombates = "./sonidos/Combates.wav";
        String rutaSonidoFisicoAliado = "./sonidos/FisicoAliado.wav";
        String rutaSonidoFisicoEnemigo = "./sonidos/FisicoEnemigo.wav";
        String rutaSonidoHabilidadesObjetos = "./sonidos/HabilidadesObjetos.wav";
        String rutaSonidoDefensa = "./sonidos/Defensa.wav";
        String rutaSonidoCuraciones = "./sonidos/Curaciones.wav";
        
        Scanner sc=new Scanner(System.in);
        int dañar;
        int aleatorio;
        boolean heroesVivos=true;
        boolean enemigosVivos=true;
        boolean defensaHeroe=false;
        boolean defensaEnemigo=false;
        

        do{
            //TURNO ALIADO
            if(heroes.getSalud()>0){
                System.out.println("----------------------------------------------");
                System.out.println("Turno de "+heroes.getNombre()+" - Vida restante: "+heroes.getSalud()+"/"+heroes.getSaludMaxima());
                System.out.println("\tAtaque(1),Defensa(2),Habilidades(3),Objetos(4)");
                int opciones=sc.nextInt();

                switch(opciones){
                    case 1:
                       aleatorio = NumeroAleatorio(0, 2);
                       if(heroes.getAgilidad()>enemigos.getAgilidad()){
                            System.out.println("!!GOLPE CRITICO!!");
                            dañar = heroes.getFuerza()*2;
                            enemigos.daño(enemigos,dañar);
                            System.out.println("- "+heroes.getNombre()+" inflige "+heroes.getFuerza()*2+" puntos de daño.");
                            System.out.println("- "+enemigos.getNombre()+" bloquea "+enemigos.getDefensa()+" puntos de daño.");
                        }else if(heroes.getAgilidad()==enemigos.getAgilidad()){
                            dañar = heroes.getFuerza();
                            enemigos.daño(enemigos,dañar);
                            System.out.println("- "+heroes.getNombre()+" inflige "+heroes.getFuerza()+" puntos de daño.");
                            System.out.println("- "+enemigos.getNombre()+" bloquea "+enemigos.getDefensa()+" puntos de daño.");
                        }else{
                            if(aleatorio==0){
                                System.out.println("Ataque fallado");
                            }else{
                                dañar = heroes.getFuerza();
                                enemigos.daño(enemigos,dañar);
                                System.out.println(heroes.getNombre()+" inflige "+heroes.getFuerza()+" puntos de daño.");
                                System.out.println("- "+enemigos.getNombre()+" bloquea "+enemigos.getDefensa()+" puntos de daño.");
                            }
                        }
                        Musica.iniciarSonidos(rutaSonidoFisicoAliado);
                        break;

                    case 2:
                        Musica.iniciarSonidos(rutaSonidoDefensa);
                        System.out.println(heroes.getNombre()+" duplica su defensa durante un turno..\n");
                        break;

                    case 3:
                        String listaHabilidades="";
                        for (int i = 0; i < heroes.getHabilidadesArray().size(); i++) {
                            listaHabilidades +="\t("+(i+1)+")"+heroes.getHabilidadesArray().get(i).getNombre()+" - Usos restantes:*"+heroes.getHabilidadesArray().get(i).getUsosRestantes()+"*";
                        }     
                        System.out.println(listaHabilidades);
                        opciones=sc.nextInt();
                            switch(opciones){
                                case 1:
                                    if(heroes.getHabilidadesArray().get(0).getUsosRestantes()>0){
                                        System.out.println(heroes.getNombre()+" usa "+heroes.getHabilidadesArray().get(0).getNombre()
                                            +" e inflige una cantidad de "+heroes.getMagia()*heroes.getHabilidadesArray().get(0).getEspecial()+" puntos de daño.");
                                        heroes.getHabilidadesArray().get(0).setUsosRestantes(heroes.getHabilidadesArray().get(0).getUsosRestantes()-1);                     
                                        enemigos.dañoHabilidades(heroes, opciones-1);
                                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                                    }else{    
                                        System.out.println("No puedes utilizar la habilidad. Pierdes el turno.");
                                    }
                                    break;
                                case 2:
                                    if(heroes.getHabilidadesArray().get(1).getUsosRestantes()>0){
                                        System.out.println(heroes.getNombre()+" usa "+heroes.getHabilidadesArray().get(1).getNombre()
                                            +" e inflige una cantidad de "+heroes.getMagia()*heroes.getHabilidadesArray().get(1).getEspecial()+" puntos de daño.");
                                        heroes.getHabilidadesArray().get(1).setUsosRestantes(heroes.getHabilidadesArray().get(1).getUsosRestantes()-1);                     
                                        enemigos.dañoHabilidades(heroes, opciones-1);
                                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                                    }else{
                                        System.out.println("No puedes utilizar la habilidad. Pierdes el turno.");
                                    }
                                    break;
                            }
                        break;

                    case 4:
                        String listaObjetos="";
                        for (int i = 0; i < heroes.getObjetosArray().size(); i++) {
                            listaObjetos +="\t("+(i+1)+")"+heroes.getObjetosArray().get(i).getNombre()+" - Usos restantes:*"+heroes.getObjetosArray().get(i).getCantidad()+"*";
                        }     
                        System.out.println(listaObjetos);
                        opciones=sc.nextInt();
                        switch(opciones){
                                case 1:
                                    if(heroes.getObjetosArray().get(0).getCantidad()>0){
                                        System.out.println(heroes.getNombre()+" usa "+heroes.getObjetosArray().get(0).getNombre()
                                            +" e inflige una cantidad de "+heroes.getObjetosArray().get(0).getPoder()+" puntos de daño.");
                                        heroes.getObjetosArray().get(0).setCantidad(heroes.getObjetosArray().get(0).getCantidad()-1);                     
                                        enemigos.dañoObjetos(heroes, opciones-1);
                                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                                    }else{    
                                        System.out.println("No te quedan objetos. Pierdes el turno.");
                                    }
                                    break;
                                case 2:
                                    if(heroes.getObjetosArray().get(1).getCantidad()>0){
                                        System.out.println(heroes.getNombre()+" usa "+heroes.getObjetosArray().get(1).getNombre()
                                            +" e inflige una cantidad de "+heroes.getObjetosArray().get(1).getPoder()+" puntos de daño.");
                                        heroes.getObjetosArray().get(1).setCantidad(heroes.getObjetosArray().get(1).getCantidad()-1);                     
                                        enemigos.dañoObjetos(heroes, opciones-1);
                                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                                    }else{
                                        System.out.println("No te quedan objetos. Pierdes el turno.");
                                    }
                                    break;
                                case 3:
                                    if(heroes.getObjetosArray().get(2).getCantidad()>0){
                                        System.out.println(heroes.getNombre()+" usa "+heroes.getObjetosArray().get(2).getNombre()
                                            +" y restaura una cantidad de "+heroes.getObjetosArray().get(2).getPoder()+" puntos de salud.");
                                        heroes.getObjetosArray().get(2).setCantidad(heroes.getObjetosArray().get(2).getCantidad()-1);                     
                                        heroes.curacionObjetos(heroes, opciones-1);
                                        Musica.iniciarSonidos(rutaSonidoCuraciones);
                                    }else{
                                        System.out.println("No te quedan objetos. Pierdes el turno.");
                                    }
                                    break;
                            }
                        break;
                }

            }else{
                System.out.println("\n\tDERROTA - Juega mejor la proxima vez ^_^");
                heroesVivos=false;
                break;
            }
            //TURNO ENEMIGO
            if(enemigos.getSalud()>0){
            System.out.println("----------------------------------------------");
            System.out.println("Turno de "+enemigos.getNombre()+" - Vida restante: "+enemigos.getSalud()+"/"+enemigos.getSaludMaxima());
            aleatorio = NumeroAleatorio(0, 6);                
                if(aleatorio<=3){ 
                    System.out.println("\tDecide atacar!\n");
                    aleatorio = NumeroAleatorio(0, 2);
                    if(enemigos.getAgilidad()>heroes.getAgilidad()){
                        System.out.println("!!GOLPE CRITICO!!");
                        dañar = enemigos.getFuerza()*2;
                        heroes.daño(heroes,dañar);
                        System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()*2+" puntos de daño.");
                        System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                        Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                    }else if(enemigos.getAgilidad()==heroes.getAgilidad()){
                        dañar = enemigos.getFuerza();
                        heroes.daño(heroes,dañar);
                        System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()+" puntos de daño.");
                        System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                        Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                    }else{
                        if(aleatorio==0){
                            System.out.println("Ataque fallado");
                        }else{
                            dañar = enemigos.getFuerza();
                            heroes.daño(heroes,dañar);
                            System.out.println(enemigos.getNombre()+" inflige "+enemigos.getFuerza()+" puntos de daño.");
                            System.out.println(+heroes.getDefensa()+" puntos de daño son bloqueados por la defensa enemiga.");
                            Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                                }
                            }
                }else if(aleatorio==4){
                    System.out.println("\tDecide usar bloqueo!\n");
                    Musica.iniciarSonidos(rutaSonidoDefensa);
                }else{
                    System.out.println("\tDecide usar una habilidad!\n");
                    aleatorio = NumeroAleatorio(0, 6);  
                    if(aleatorio<=3){
                        if(enemigos.getHabilidadesArray().get(0).getUsosRestantes()>0){
                            System.out.println(enemigos.getNombre()+" usa "+enemigos.getHabilidadesArray().get(0).getNombre()
                                +" e inflige una cantidad de "+enemigos.getMagia()*enemigos.getHabilidadesArray().get(0).getEspecial()+" puntos de daño.");
                            enemigos.getHabilidadesArray().get(0).setUsosRestantes(enemigos.getHabilidadesArray().get(0).getUsosRestantes()-1);                     
                            heroes.dañoHabilidades(enemigos, 0); 
                        }else{    
                            System.out.println("No puede utilizar la habilidad. Pierde el turno.");
                        }
                    }else{
                        if(enemigos.getHabilidadesArray().get(1).getUsosRestantes()>0){
                            System.out.println(enemigos.getNombre()+" usa "+enemigos.getHabilidadesArray().get(1).getNombre()
                                +" e inflige una cantidad de "+enemigos.getMagia()*enemigos.getHabilidadesArray().get(1).getEspecial()+" puntos de daño.");
                            enemigos.getHabilidadesArray().get(0).setUsosRestantes(enemigos.getHabilidadesArray().get(1).getUsosRestantes()-1);                     
                            heroes.dañoHabilidades(enemigos, 1); 
                        }else{    
                            System.out.println("No puede utilizar la habilidad. Pierde el turno.");
                        }
                    }
                    Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                }
            }else{
                enemigosVivos=false;
                System.out.println("!!!Enemigos Derrotados!!!");
                //INCLUIR DINERO SOLTADO POR LOS ENEMIGOS
                Musica.iniciarMusica(rutaCancionVictoria);
                //Despues de cada combate regeneramos la salud de los heroes y los enemigos (por si en otro eventos luchamos contra ellos.
                heroes.regenerarSaludHabilidades(heroes);
                enemigos.regenerarSaludHabilidades(enemigos);
            }
        }while(heroesVivos&&enemigosVivos);
    }

    public static int NumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
   }
}

