package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.Objects;
import DLists.*;

public class top10Screen extends VBox {

	public top10Screen(DLinkedList Top10) {

		this.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("c_form_styles.css")).toExternalForm());

		this.setPadding(new Insets(60));
		this.setSpacing(40);
		this.setAlignment(Pos.CENTER);

		DNode curr = Top10.getHead();
		while (curr != null) {

			Label lbl = new Label(curr.toString());

			this.getChildren().add(lbl);

			if (curr.next == null) {
				break;
			}
			curr = curr.next;

		}

	}

}