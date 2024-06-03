package fr.but.info.sae122.seance3;

import fr.but.info.sae122.seance3.model.Graph;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class PlaceMouseController extends MouseController implements Initializable {

	private Controller controller;

	public PlaceMouseController(Graph graph, Controller controller) {
		super(graph);
		this.controller = controller;
	}

	public void onMousePressed(MouseEvent evt) {
		boolean bon = false;
		TextInputDialog dialog = new TextInputDialog("");
		while(!bon) {
			String nom = "N"+controller.nodes.size();
			dialog = new TextInputDialog(nom);
			dialog.setContentText("Entre le nom de ton Noeud :");
			dialog.showAndWait();
			if(!this.graph.getNodes().contains(dialog.getResult())){
				bon = true;
			}
		}
		this.graph.addNode(dialog.getResult());
		GraphicNode node = new GraphicNode(evt.getX(),evt.getY(),50,"red");
		controller.addNode(dialog.getResult(), node);
		controller.guideUser("Placer le noeud a l'écran...",Cursor.DEFAULT);
		controller.setMouseController(new IdleMouseController(graph,this.controller));
	}
}
