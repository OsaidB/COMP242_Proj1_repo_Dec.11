package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Objects;

public class top10Screen extends VBox {

	public <T> top10Screen(DLinkedList gazaTop10) {

		this.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("c_form_styles.css")).toExternalForm());

		this.setPadding(new Insets(60));
		this.setSpacing(40);
		
		DNode<T> curr = gazaTop10.head;
		for (int i = 0; i < 9; i++) {

			Label lbl = new Label(curr.toString());
			
			this.getChildren().add(lbl);
			
			if (curr.getNext() == null) {
				break;
			}
			curr = curr.getNext();

		}

	}

}