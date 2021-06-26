package application;

import graph.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Main_whole extends Application {
    Graph graph = new Graph();
    private Button cnode, mnode, dnode;
    private double sceneX, sceneY, layoutX, layoutY;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        ToolBar toolbar = new ToolBar();
        VBox left = new VBox();
        Pane center = new Pane();
        VBox right = new VBox();
        HBox bottom = new HBox();
        root.setTop(toolbar);
        root.setLeft(left);
        root.setCenter(center);
        root.setRight(right);
        root.setBottom(bottom);

//        graph = new Graph();
//        root.setCenter(graph.getScrollPane());

        // create the node buttons
        cnode = new Button("Collection Node");
        cnode.setText("C");
        cnode.setTooltip(new Tooltip("Info tip for c node: Collect output of functions applied to Mode or Data I/O Nodes."));
        double r = 25;
        cnode.setShape(new Circle(r));
        cnode.setMinSize(2*r, 2*r);
        cnode.setMaxSize(2*r, 2*r);

        mnode = new Button("Model Node");
        mnode.setText("M");
        mnode.setTooltip(new Tooltip("Info tip for m node: A saved model or code."));
        mnode.setShape(new Rectangle(100,100));

        dnode = new Button("Data I/O Node");
        dnode.setText("D");
        dnode.setTooltip(new Tooltip("Info tip for d node: Takes in data from external sources (sensors)."));
        double width = 50;
        double height = 50;
        dnode.setShape(new Polygon( width / 2, 0, width, height, 0, height));

        // functions in right VBox
        final Text function1 = new Text(50, 100, "Function 1");
        function1.setScaleX(2.0);
        function1.setScaleY(2.0);

        final Text function2 = new Text(50, 100, "Function 2");
        function2.setScaleX(2.0);
        function2.setScaleY(2.0);

        final Text function3 = new Text(50, 100, "Function 3");
        function3.setScaleX(2.0);
        function3.setScaleY(2.0);

        final Text target= new Text(250, 100, " Workspace");
        target.setScaleX(1.5);
        target.setScaleY(1.5);

        // left VBox with nodes and conditional connectors
        left.getChildren().addAll(cnode, mnode, dnode);
        cnode.setStyle("-fx-font-size: 1.5em; ");
        mnode.setStyle("-fx-font-size: 1.5em; ");
        dnode.setStyle("-fx-font-size: 1.5em; ");
        left.setStyle("-fx-border-color: black");
        left.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
        left.setAlignment(Pos.CENTER);
        left.setSpacing(30);

//        // right VBox with functions
//        right.getChildren().addAll(function1, function2, function3);
//        right.setStyle("-fx-border-color: black");
//        right.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
//        right.setAlignment(Pos.CENTER);
//        right.setSpacing(30);

        // mid Pane with labels
        center.getChildren().add(target);
        center.setStyle("-fx-border-color: black");
        center.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.5));
        // set font size for label in Pane
        DoubleProperty fontSize3= new SimpleDoubleProperty(18); // font size in pt
        center.styleProperty().bind(Bindings.format("-fx-font-size: %.2fpt;", fontSize3));

        // drag and drop functions
        cnode.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db= cnode.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content= new ClipboardContent();
                content.putString(cnode.getText());
                db.setContent(content);
                event.consume();
            }
        });

        mnode.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db= mnode.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content= new ClipboardContent();
                content.putString(mnode.getText());
                db.setContent(content);
                event.consume();
            }
        });

        dnode.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db= mnode.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content= new ClipboardContent();
                content.putString(dnode.getText());
                db.setContent(content);
                event.consume();
            }
        });

        function1.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db= function1.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content= new ClipboardContent();
                content.putString(function1.getText());
                db.setContent(content);
                event.consume();
            }
        });

        function2.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db= function2.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content= new ClipboardContent();
                content.putString(function2.getText());
                db.setContent(content);
                event.consume();
            }
        });

        function3.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db= function3.startDragAndDrop(TransferMode.ANY);

                /* put a string on dragboard */
                ClipboardContent content= new ClipboardContent();
                content.putString(function3.getText());
                db.setContent(content);
                event.consume();
            }
        });

        // to be dropped(target): center(workspace)in general, C/M/D labels
        center.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != center &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        //update source_nodes array each time a node in the workspace is named
        ArrayList<Label> source_nodes = new ArrayList<Label>();
        ComboBox sources = new ComboBox(FXCollections.observableArrayList(source_nodes));
        Label selected1 = new Label("default item selected");
        EventHandler<ActionEvent> source_selection = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selected1.setText(sources.getValue() + " selected");
            }
        };
        sources.setOnAction(source_selection);
        TilePane source_pane = new TilePane(sources, selected1);
        left.getChildren().add(source_pane);

        //update target_nodes array each time a node in the workspace is named
        ArrayList<Label> destination_nodes = new ArrayList<>();
        ComboBox destinations = new ComboBox(FXCollections.observableArrayList(destination_nodes));
        Label selected2 = new Label("default item selected");
        EventHandler<ActionEvent> target_selection = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selected2.setText(destinations.getValue() + " selected");
            }
        };
        destinations.setOnAction(target_selection);
        TilePane target_pane = new TilePane(destinations, selected2);
        left.getChildren().add(target_pane);

        center.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db= event.getDragboard();
                System.out.println(db.getString());

                boolean success= false;

                if (db.getString().equals("C")) {
                    Button cnod= new Button("Collection Node");
                    center.getChildren().add(cnod);
                    cnod.setText("C");
                    double r= 25;
                    cnod.setShape(new Circle(r));
                    cnod.setMinSize(2 * r, 2 * r);
                    cnod.setMaxSize(2 * r, 2 * r);
                    Label clbl= new Label("Add to C");
                    center.getChildren().add(clbl);

                    cnod.setOnMousePressed(e -> {
                        sceneX= e.getSceneX();
                        sceneY= e.getSceneY();
                        layoutX= cnod.getLayoutX();
                        layoutY= cnod.getLayoutY();
                        System.out.println(cnod.getText() + " Box onStart :: layoutX ::" + layoutX +
                                        ", layoutY::" + layoutY);
                    });
                    // drag around
                    cnod.setOnMouseDragged(e -> {
                        double offsetX= e.getSceneX() - sceneX;
                        double offsetY= e.getSceneY() - sceneY;
                        cnod.setTranslateX(offsetX);
                        cnod.setTranslateY(offsetY);
                    });
                    cnod.setOnMouseReleased(e -> {
                        // Updating the new layout positions
                        cnod.setLayoutX(layoutX + cnod.getTranslateX());
                        cnod.setLayoutY(layoutY + cnod.getTranslateY());

                        // Resetting the translate positions
                        cnod.setTranslateX(0);
                        cnod.setTranslateY(0);
                    });
                    cnod.setOnAction(e -> {
                        System.out.println("Button pressed " + ((Button) e.getSource()).getText());
                        
                        // TODO: Showing the properties of the node on the right
                        VBox property = new VBox();
                        root.setRight(property);
                        final Text property_title = new Text(50, 100, "Property for C node");
                        property_title.setScaleX(2.0);
                        property_title.setScaleY(2.0);
                        final Text property1 = new Text(50, 100, "Name:");
                        TextField name = new TextField();
//                        cnod.setText(name.getText());
                        final Text property2 = new Text(50, 100, "Path:");
                        TextField path = new TextField();
                        property.getChildren().addAll(property_title, property1, name, property2, path);
                        property.setStyle("-fx-border-color: black");
                        property.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
                        property.setAlignment(Pos.CENTER);
                        property.setSpacing(30);
                    });
                    clbl.setOnDragOver(new EventHandler<DragEvent>() {
                        @Override
                        public void handle(DragEvent event) {
                            /* data is dragged over the target */
                            System.out.println("onDragOver");

                            /* accept it only if it is  not dragged from the same node
                             * and if it has a string data */
                            if (event.getGestureSource() != clbl &&
                                    event.getDragboard().hasString()) {
                                /* allow for both copying and moving, whatever user chooses */
                                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                            }
                            event.consume();
                        }
                    });
                    clbl.setOnDragDropped(new EventHandler<DragEvent>() {
                        @Override
                        public void handle(DragEvent event) {
                            if (db.getString().equals("Function 1")) {
                                Label clbl= new Label("C: Function 1");
                                center.getChildren().add(clbl);
                            }
                            if (db.getString().equals("Function 2")) {
                                Label clbl= new Label("C: Function 2");
                                center.getChildren().add(clbl);
                            }
                        }
                    });
                    source_nodes.add(clbl);
                    sources.setItems((ObservableList) source_nodes);
                    destination_nodes.add(clbl);
                }

                if (db.getString().equals("M")) {
                    Button mnod= new Button("M");
                    mnod.setText("M");
                    mnod.setShape(new Rectangle(100, 100));
                    center.getChildren().add(mnod);
                    Label mlbl= new Label("Add to M");
                    center.getChildren().add(mlbl);

                    mnod.setOnMousePressed(e -> {
                        sceneX= e.getSceneX();
                        sceneY= e.getSceneY();
                        layoutX= mnod.getLayoutX();
                        layoutY= mnod.getLayoutY();
                        System.out.println(mnod.getText() + " Box onStart :: layoutX ::" + layoutX +
                                        ", layoutY::" + layoutY);
                    });
                    mnod.setOnMouseDragged(e -> {
                        double offsetX= e.getSceneX() - sceneX;
                        double offsetY= e.getSceneY() - sceneY;
                        mnod.setTranslateX(offsetX);
                        mnod.setTranslateY(offsetY);
                    });
                    mnod.setOnMouseReleased(e -> {
                        // Updating the new layout positions
                        mnod.setLayoutX(layoutX + mnod.getTranslateX());
                        mnod.setLayoutY(layoutY + mnod.getTranslateY());

                        // Resetting the translate positions
                        mnod.setTranslateX(0);
                        mnod.setTranslateY(0);
                    });
                    mnod.setOnAction(e -> {
                        System.out.println("Button pressed " + ((Button) e.getSource()).getText());
                        
                     // TODO: Showing the properties of the node on the right
                        VBox property = new VBox();
                        root.setRight(property);
                        final Text property_title = new Text(50, 100, "Property for M node");
                        property_title.setScaleX(2.0);
                        property_title.setScaleY(2.0);
                        final Text property1 = new Text(50, 100, "Name:");
                        TextField name = new TextField();
//                        mnod.setText(name.getText());
                        final Text property2 = new Text(50, 100, "Path:");
                        TextField path = new TextField();
                        property.getChildren().addAll(property_title, property1, name, property2, path);
                        property.setStyle("-fx-border-color: black");
                        property.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
                        property.setAlignment(Pos.CENTER);
                        property.setSpacing(30);
                    });
                    mlbl.setOnDragOver(new EventHandler<DragEvent>() {
                        @Override
                        public void handle(DragEvent event) {
                            /* data is dragged over the target */
                            System.out.println("onDragOver");

                            /* accept it only if it is  not dragged from the same node
                             * and if it has a string data */
                            if (event.getGestureSource() != mlbl &&
                                    event.getDragboard().hasString()) {
                                /* allow for both copying and moving, whatever user chooses */
                                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                            }
                            event.consume();
                        }
                    });
                    mlbl.setOnDragDropped(new EventHandler<DragEvent>() {
                        @Override
                        public void handle(DragEvent event) {
                            if (db.getString().equals("Function 1")) {
                                Label mlbl= new Label("M: Function 1");
                                center.getChildren().add(mlbl);
                            }
                            if (db.getString().equals("Function 2")) {
                                Label mlbl= new Label("M: Function 2");
                                center.getChildren().add(mlbl);
                            }
                        }
                    });
                }

                if (db.getString().equals("D")) {
                    Button dnod= new Button("D");
                    dnod.setText("D");
                    double width= 50;
                    double height= 50;
                    dnod.setShape(new Polygon(width / 2, 0, width, height, 0, height));
                    center.getChildren().add(dnod);
                    Label dlbl= new Label("Add to D");
                    center.getChildren().add(dlbl);

                    dnod.setOnMousePressed(e -> {
                        sceneX= e.getSceneX();
                        sceneY= e.getSceneY();
                        layoutX= dnod.getLayoutX();
                        layoutY= dnod.getLayoutY();
                        System.out.println(dnod.getText() + " Box onStart :: layoutX ::" + layoutX +
                                        ", layoutY::" + layoutY);
                    });
                    dnod.setOnMouseDragged(e -> {
                        double offsetX= e.getSceneX() - sceneX;
                        double offsetY= e.getSceneY() - sceneY;
                        dnod.setTranslateX(offsetX);
                        dnod.setTranslateY(offsetY);
                    });
                    dnod.setOnMouseReleased(e -> {
                        // Updating the new layout positions
                        dnod.setLayoutX(layoutX + dnod.getTranslateX());
                        dnod.setLayoutY(layoutY + dnod.getTranslateY());

                        // Resetting the translate positions
                        dnod.setTranslateX(0);
                        dnod.setTranslateY(0);
                    });
                    dnod.setOnAction(e -> {
                        System.out.println("Button pressed " + ((Button) e.getSource()).getText());
                        
                     // TODO: Showing the properties of the node on the right
                        VBox property = new VBox();
                        root.setRight(property);
                        final Text property_title = new Text(50, 100, "Property for D node");
                        property_title.setScaleX(2.0);
                        property_title.setScaleY(2.0);
                        final Text property1 = new Text(50, 100, "Name:");
                        TextField name = new TextField();
//                        dnod.setText(name.getText());
                        final Text property2 = new Text(50, 100, "Path:");
                        TextField path = new TextField();
                        property.getChildren().addAll(property_title, property1, name, property2, path);
                        property.setStyle("-fx-border-color: black");
                        property.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.25));
                        property.setAlignment(Pos.CENTER);
                        property.setSpacing(30);
                    });
                    dlbl.setOnDragOver(new EventHandler<DragEvent>() {
                        @Override
                        public void handle(DragEvent event) {
                            /* data is dragged over the target */
                            System.out.println("onDragOver");

                            /* accept it only if it is  not dragged from the same node
                             * and if it has a string data */
                            if (event.getGestureSource() != dlbl &&
                                    event.getDragboard().hasString()) {
                                /* allow for both copying and moving, whatever user chooses */
                                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                            }
                            event.consume();
                        }
                    });
                    dlbl.setOnDragDropped(new EventHandler<DragEvent>() {
                        @Override
                        public void handle(DragEvent event) {
                            if (db.getString().equals("Function 1")) {
                                Label dlbl= new Label("D: Function 1");
                                center.getChildren().add(dlbl);
                            }
                            if (db.getString().equals("Function 2")) {
                                Label dlbl= new Label("D: Function 2");
                                center.getChildren().add(dlbl);
                            }
                        }
                    });
                }
//                    if (db.hasString()) {
//                        target.setText(db.getString());
//                        success= true;
//                    }

                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);
                event.consume();
            }
        });

        cnode.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    cnode.setText("");
                }
                event.consume();
            }
        });

        mnode.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    mnode.setText("");
                }
                event.consume();
            }
        });

        dnode.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    dnode.setText("");
                }
                event.consume();
            }
        });

        HBox hbox = new HBox();
        hbox.getChildren().addAll(root);

        Scene scene = new Scene(hbox, 900, 600);
        scene.getStylesheets().add(getClass().getResource("pipeline.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

//        addGraphComponents();
//        Layout layout = new RandomLayout(graph);
//        layout.execute();
    }

    private void addGraphComponents() {
        Model model = graph.getModel();
        graph.beginUpdate();

        model.addCell("Cell A", CellType.RECTANGLE);
        model.addCell("Cell B", CellType.RECTANGLE);
        model.addCell("Cell C", CellType.TRIANGLE);
        model.addCell("Cell D", CellType.TRIANGLE);
        model.addCell("Cell E", CellType.CIRCLE);
        model.addCell("Cell F", CellType.CIRCLE);
        model.addCell("Cell G", CellType.CIRCLE);

//        model.addEdge("Cell A", "Cell B");
//        model.addEdge("Cell B", "Cell C");
//        model.addEdge("Cell C", "Cell D");
//        model.addEdge("Cell D", "Cell E");
//        model.addEdge("Cell E", "Cell F");
//        model.addEdge("Cell F", "Cell G");

        graph.endUpdate();
    }

    public static void main(String[] args) {
        launch(args);
    }
}