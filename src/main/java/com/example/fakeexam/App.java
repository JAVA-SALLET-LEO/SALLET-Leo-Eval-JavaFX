package com.example.fakeexam;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicInteger;

public class App extends Application {
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Formulaire");



        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(0); // espacement verticaux
        grid.setHgap(10); // espacement horizontaux

        Button ConsulterButton = new Button("Consulter les données");
        Button TelechargerButton = new Button("Telecharger le fichier");
        Button meteoButton = new Button("Mettre la météo a jour");
        Button bonusButton = new Button("Bonus");

        GridPane.setConstraints(ConsulterButton, 2, 1);
        GridPane.setConstraints(TelechargerButton, 2, 2);
        GridPane.setConstraints(meteoButton, 2, 3);
        GridPane.setConstraints(bonusButton, 2, 4);

        grid.getChildren().addAll(ConsulterButton,TelechargerButton,meteoButton,bonusButton);

        meteoButton.setOnAction(e -> {

            VBox vbox = new VBox();
            vbox.setPadding(new Insets(10, 10, 10, 10));
            GridPane StationGrid = new GridPane();

                    Label nomLabel = new Label(String.format("nom"));
                    TextField nomInput = new TextField();
                    Label prenomLabel = new Label(String.format("prenom"));
                    TextField prenomInput = new TextField();
                    Label villeLabel = new Label(String.format("ville:"));
                    TextField villeInput = new TextField();
                    Label temperatureLabel = new Label(String.format("température:"));
                    TextField temperatureInput = new TextField();
                    Label meteoLabel = new Label(String.format("météo:"));
                    TextField meteoInput = new TextField();
                    StationGrid.add(nomLabel, 0,0);
                    StationGrid.add(nomInput, 1,0);
                    StationGrid.add(prenomLabel, 0,1);
                    StationGrid.add(prenomInput, 1,1);
                    StationGrid.add(villeLabel, 0,2);
                    StationGrid.add(villeInput, 1,2);
                    StationGrid.add(temperatureLabel, 0,3);
                    StationGrid.add(temperatureInput, 1,3);
                    StationGrid.add(meteoLabel, 0,4);
                    StationGrid.add(meteoInput, 1,4);

                    Button valider = new Button("Valider");
                    Button backbutton = new Button("Retour");
                    StationGrid.add(valider,1,7);
                    StationGrid.add(backbutton,2,7);
            backbutton.setOnAction(e2 -> {
                window.setScene(grid.getScene());
            });





            vbox.getChildren().addAll(StationGrid);
            HBox hbox = new HBox();
            hbox.getChildren().addAll(vbox);
            Scene scene2 = new Scene(hbox, 400, 200);
            window.setScene(scene2);
        });

        TelechargerButton.setOnAction(e->{
            VBox vbox = new VBox();
            vbox.setPadding(new Insets(10, 10, 10, 10));

            GridPane grid1 = new GridPane();
            grid1.setPadding(new Insets(10, 10, 10, 10));
            TextField villeInput = new TextField("US");
            Button Button5 =new Button("telecharger");
            vbox.getChildren().addAll(Button5);
            Button backButton = new Button("Retour");
            backButton.setOnAction(e2 -> {
                window.setScene(grid.getScene());
            });

            Label villeLabel = new Label("Nom de la ville ");


            grid1.add(villeLabel,0,0);
            grid1.add(villeInput,1,0);


            Label messageLabel = new Label("");
            grid1.add(backButton,0,1);
            grid1.add(Button5,2,0);
            Button5.setOnAction(e1 -> {
                try {
                    URL url = new URL("http://api.weatherstack.com/current?access_key=a7aa2f1e4e247c1561144c67c6c3cedb&query="+villeInput.getText());
                    URLConnection connection = url.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream("meteo-"+villeInput.getText()+".json");
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, length);
                    }
                    outputStream.close();
                    inputStream.close();
                    String path = new File("meteo-"+villeInput.getText()+".json").getAbsolutePath();
                    String message = "Fichier téléchargé avec succès:" + path;
                    System.out.println(message);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

// Ajouter le label à votre scène existante
            VBox vbox1 = new VBox();
            vbox1.setAlignment(Pos.CENTER);
            vbox1.setPadding(new Insets(25, 25, 25, 25));
            vbox1.setSpacing(10);
            Button button1 = new Button("Télécharger le fichier");
            vbox1.getChildren().addAll(button1, messageLabel);
            HBox hbox = new HBox();
            grid1.add(messageLabel,0,2);
            hbox.getChildren().addAll(vbox, grid1);
            Scene scene2 = new Scene(hbox, 400, 200);
            window.setScene(scene2);
        });

        bonusButton.setOnAction(e->{

            AtomicInteger tour = new AtomicInteger(0);

            AtomicInteger verifsiend = new AtomicInteger(0);

            AtomicInteger nbr1 = new AtomicInteger(0);
            AtomicInteger nbr2 = new AtomicInteger(0);
            AtomicInteger nbr3 = new AtomicInteger(0);
            AtomicInteger nbr4 = new AtomicInteger(0);
            AtomicInteger nbr5 = new AtomicInteger(0);
            AtomicInteger nbr6 = new AtomicInteger(0);
            AtomicInteger nbr7 = new AtomicInteger(0);
            AtomicInteger nbr8 = new AtomicInteger(0);
            AtomicInteger nbr9 = new AtomicInteger(0);

            AtomicInteger nbr1x = new AtomicInteger(0);
            AtomicInteger nbr1o = new AtomicInteger(0);

            AtomicInteger nbr2x = new AtomicInteger(0);
            AtomicInteger nbr2o = new AtomicInteger(0);

            AtomicInteger nbr3x = new AtomicInteger(0);
            AtomicInteger nbr3o = new AtomicInteger(0);

            AtomicInteger nbr4x = new AtomicInteger(0);
            AtomicInteger nbr4o = new AtomicInteger(0);

            AtomicInteger nbr5x = new AtomicInteger(0);
            AtomicInteger nbr5o = new AtomicInteger(0);

            AtomicInteger nbr6x = new AtomicInteger(0);
            AtomicInteger nbr6o = new AtomicInteger(0);

            AtomicInteger nbr7x = new AtomicInteger(0);
            AtomicInteger nbr7o = new AtomicInteger(0);

            AtomicInteger nbr8x = new AtomicInteger(0);
            AtomicInteger nbr8o = new AtomicInteger(0);

            AtomicInteger nbr9x = new AtomicInteger(0);
            AtomicInteger nbr9o = new AtomicInteger(0);





            VBox vbox = new VBox();
            vbox.setPadding(new Insets(10, 10, 10, 10));
            GridPane StationGrid = new GridPane();

            Button firstlgnpremiereclButton = new Button("");
            firstlgnpremiereclButton.setMinSize(25,25);
            Button firstlgndeuxiemeclButton = new Button("");
            firstlgndeuxiemeclButton.setMinSize(25,25);
            Button firstlgntroisiemeclButton = new Button("");
            firstlgntroisiemeclButton.setMinSize(25,25);
            Button deuxiemelgnpremiereclButton = new Button("");
            deuxiemelgnpremiereclButton.setMinSize(25,25);
            Button deuxiemelgndeuxiemeclButton = new Button("");
            deuxiemelgndeuxiemeclButton.setMinSize(25,25);
            Button deuxiemelgntroisiemeclButton = new Button("");
            deuxiemelgntroisiemeclButton.setMinSize(25,25);
            Button troisiemelgnpremiereclButton = new Button("");
            troisiemelgnpremiereclButton.setMinSize(25,25);
            Button troisiemelgndeuxiemeclButton = new Button("");
            troisiemelgndeuxiemeclButton.setMinSize(25,25);
            Button troisiemelgntroisiemeclButton = new Button("");
            troisiemelgntroisiemeclButton.setMinSize(25,25);
            Label findujeu = new Label("");
            Label commentaires = new Label(" O commence, puis X");

            firstlgnpremiereclButton.setOnAction(e1->{
                nbr1.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr1.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            firstlgnpremiereclButton.setText("O");
                            tour.getAndIncrement();
                            nbr1o.getAndIncrement();
                            if (nbr2o.get() == 1) {
                                if (nbr3o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");
                                }
                            }
                            if (nbr4o.get() == 1) {
                                if (nbr7o.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5o.get() == 1) {
                                if (nbr9o.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }

                        } else {
                            firstlgnpremiereclButton.setText("X");
                            tour.getAndIncrement();
                            nbr1x.getAndIncrement();
                            if (nbr2x.get() == 1) {
                                if (nbr2x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr4x.get() == 1) {
                                if (nbr7x.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5x.get() == 1) {
                                if (nbr9x.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                        }
                    }
                }



            });
            firstlgndeuxiemeclButton.setOnAction(e1->{
                nbr2.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr2.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            firstlgndeuxiemeclButton.setText("O");
                            tour.getAndIncrement();
                            nbr2o.getAndIncrement();
                            if (nbr5o.get() == 1) {
                                if (nbr8o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr1o.get() == 1) {
                                if (nbr3o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }

                        } else {
                            firstlgndeuxiemeclButton.setText("X");
                            tour.getAndIncrement();
                            nbr2x.getAndIncrement();
                            if (nbr5x.get() == 1) {
                                if (nbr8x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr1x.get() == 1) {
                                if (nbr3x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }

                        }
                    }
                }
            });


            firstlgntroisiemeclButton.setOnAction(e1->{
                nbr3.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr3.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            firstlgntroisiemeclButton.setText("O");
                            tour.getAndIncrement();
                            nbr3o.getAndIncrement();
                            if (nbr2o.get() == 1) {
                                if (nbr1o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr6o.get() == 1) {
                                if (nbr9o.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5o.get() == 1) {
                                if (nbr7o.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }

                        } else {
                            firstlgntroisiemeclButton.setText("X");
                            tour.getAndIncrement();
                            nbr1x.getAndIncrement();
                            if (nbr2x.get() == 1) {
                                if (nbr1x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr6x.get() == 1) {
                                if (nbr9x.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5x.get() == 1) {
                                if (nbr7x.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                        }
                    }
                }
            });
            deuxiemelgnpremiereclButton.setOnAction(e1->{
                nbr4.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr4.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            deuxiemelgnpremiereclButton.setText("O");
                            tour.getAndIncrement();
                            nbr4o.getAndIncrement();
                            if (nbr5o.get() == 1) {
                                if (nbr6o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr1o.get() == 1) {
                                if (nbr7o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }

                        } else {
                            deuxiemelgnpremiereclButton.setText("X");
                            tour.getAndIncrement();
                            nbr4x.getAndIncrement();
                            if (nbr5x.get() == 1) {
                                if (nbr6x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr1x.get() == 1) {
                                if (nbr7x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                        }
                    }
                }
            });
            deuxiemelgndeuxiemeclButton.setOnAction(e1->{
                nbr5.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr5.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            deuxiemelgndeuxiemeclButton.setText("O");
                            tour.getAndIncrement();
                            nbr5o.getAndIncrement();
                            if (nbr4o.get() == 1) {
                                if (nbr6o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr2o.get() == 1) {
                                if (nbr8o.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr1o.get() == 1) {
                                if (nbr9o.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr3o.get() == 1) {
                                if (nbr7o.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }


                        } else {
                            deuxiemelgndeuxiemeclButton.setText("X");
                            tour.getAndIncrement();
                            nbr5x.getAndIncrement();
                            if (nbr4x.get() == 1) {
                                if (nbr6x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr2x.get() == 1) {
                                if (nbr8x.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr1x.get() == 1) {
                                if (nbr9x.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr3x.get() == 1) {
                                if (nbr7x.get()== 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                        }
                    }
                }
            });
            deuxiemelgntroisiemeclButton.setOnAction(e1->{
                nbr6.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr6.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            deuxiemelgntroisiemeclButton.setText("O");
                            tour.getAndIncrement();
                            nbr6o.getAndIncrement();
                            if (nbr5o.get() == 1) {
                                if (nbr4o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr3o.get() == 1) {
                                if (nbr9o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }


                        } else {
                            deuxiemelgntroisiemeclButton.setText("X");
                            tour.getAndIncrement();
                            nbr6x.getAndIncrement();
                            if (nbr3x.get() == 1) {
                                if (nbr9x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5x.get() == 1) {
                                if (nbr4x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                        }
                    }
                }
            });
            troisiemelgnpremiereclButton.setOnAction(e1->{
                nbr7.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr7.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            troisiemelgnpremiereclButton.setText("O");
                            tour.getAndIncrement();
                            nbr7o.getAndIncrement();
                            if (nbr4o.get() == 1) {
                                if (nbr1o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr8o.get() == 1) {
                                if (nbr9o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5o.get() == 1) {
                                if (nbr3o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }


                        } else {
                            troisiemelgnpremiereclButton.setText("X");
                            tour.getAndIncrement();
                            nbr6x.getAndIncrement();
                            if (nbr4x.get() == 1) {
                                if (nbr1x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr8x.get() == 1) {
                                if (nbr9x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5x.get() == 1) {
                                if (nbr3x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                        }
                    }
                }
            });
            troisiemelgndeuxiemeclButton.setOnAction(e1->{
                nbr8.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr8.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            troisiemelgndeuxiemeclButton.setText("O");
                            tour.getAndIncrement();
                            nbr8o.getAndIncrement();
                            if (nbr5o.get() == 1) {
                                if (nbr2o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr7o.get() == 1) {
                                if (nbr9o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }

                        } else {
                            troisiemelgndeuxiemeclButton.setText("X");
                            tour.getAndIncrement();
                            nbr8x.getAndIncrement();
                            if (nbr5x.get() == 1) {
                                if (nbr2x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr7x.get() == 1) {
                                if (nbr9x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }

                        }
                    }
                }
            });
            troisiemelgntroisiemeclButton.setOnAction(e1->{
                nbr9.getAndIncrement();
                if (verifsiend.get() == 0) {
                    if (nbr9.get() == 1) {
                        if (tour.get() % 2 == 0) {
                            troisiemelgntroisiemeclButton.setText("O");
                            tour.getAndIncrement();
                            nbr9o.getAndIncrement();
                            if (nbr8o.get() == 1) {
                                if (nbr7o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr6o.get() == 1) {
                                if (nbr3o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5o.get() == 1) {
                                if (nbr1o.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }


                        } else {
                            troisiemelgntroisiemeclButton.setText("X");
                            tour.getAndIncrement();
                            nbr9x.getAndIncrement();
                            if (nbr8x.get() == 1) {
                                if (nbr7x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr6x.get() == 1) {
                                if (nbr3x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                            if (nbr5x.get() == 1) {
                                if (nbr1x.get() == 1) {
                                    verifsiend.getAndIncrement();
                                    findujeu.setText("fin du jeu");

                                }
                            }
                        }
                    }
                }
            });


            StationGrid.add(firstlgnpremiereclButton,2,4);
            StationGrid.add(firstlgndeuxiemeclButton,3,4);
            StationGrid.add(firstlgntroisiemeclButton,4,4);
            StationGrid.add(deuxiemelgnpremiereclButton, 2,5 );
            StationGrid.add(deuxiemelgndeuxiemeclButton, 3,5 );
            StationGrid.add(deuxiemelgntroisiemeclButton, 4,5 );
            StationGrid.add(troisiemelgnpremiereclButton, 2,6 );
            StationGrid.add(troisiemelgndeuxiemeclButton, 3,6 );
            StationGrid.add(troisiemelgntroisiemeclButton, 4,6 );
            StationGrid.add(findujeu,7,7);
            StationGrid.add(commentaires,0,0);






            Button backbutton = new Button("Retour");

            StationGrid.add(backbutton,8,8);

            backbutton.setOnAction(e2 -> {
                window.setScene(grid.getScene());
            });





            vbox.getChildren().addAll(StationGrid);
            HBox hbox = new HBox();
            hbox.getChildren().addAll(vbox);
            Scene scene2 = new Scene(hbox, 400, 200);
            window.setScene(scene2);

        });


        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();
    }
}
