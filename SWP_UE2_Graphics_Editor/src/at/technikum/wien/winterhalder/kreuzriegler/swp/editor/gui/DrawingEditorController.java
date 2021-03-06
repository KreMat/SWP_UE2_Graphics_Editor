/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.DrawingEditorContext;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.factory.DrawablePrototypeFactoryImpl;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.renderer.CanvasRenderer;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolEvent;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolRepository;

public class DrawingEditorController {

	private CanvasRenderer renderer;

	private DrawingEditorContext context = new DrawingEditorContext();

	private RGBColor selectedColor = new RGBColor(1, 0, 0);

	private double selectedThickness = 2d;

	private boolean selectedFilled = true;

	private ITool selectedTool;

	private ToolRepository toolRepository;

	private ToggleButtonMediator toggleButtonMediator;

	@FXML
	private ToggleButton square;

	@FXML
	private ToggleButton filled;

	@FXML
	private Canvas canvas;

	@FXML
	private ColorPicker color;

	@FXML
	private Slider thickness;

	@FXML
	private ToggleButton rectangle;

	@FXML
	private ToggleButton elipse;

	@FXML
	private ToggleButton circle;

	@FXML
	private ToggleButton pen;

	@FXML
	private ToggleButton triangle;

	@FXML
	private ToggleButton move;

	@FXML
	private ToggleButton scale;

	@FXML
	private ToggleButton select;

	@FXML
	private Button group;

	@FXML
	private Button ungroup;

	@FXML
	void initialize() {
		toggleButtonMediator = new ToggleButtonMediator();
		renderer = new CanvasRenderer(canvas.getGraphicsContext2D());
		context.getRenderer().add(renderer);
		toolRepository = new ToolRepository(context,
				new DrawablePrototypeFactoryImpl());
		selectedTool = toolRepository.getSelectionTool();

		registerCanvasMouseListener();
		registerColorPicker();
		registerSlider();
		registerToggleButtonEvents();
		registerToggleButtons();

		registerFilledToggleButton();

		toggleButtonMediator.toggle(select);
	}

	private void registerFilledToggleButton() {
		filled.setSelected(selectedFilled);
		filled.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						selectedFilled = !selectedFilled;
					}
				});

	}

	private void registerSlider() {
		thickness.setMin(0.1d);
		thickness.setMax(20d);
		thickness.setValue(selectedThickness);

		thickness.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val) {
				selectedThickness = new_val.doubleValue();
			}
		});

	}

	private void registerToggleButtons() {
		toggleButtonMediator.registerButton(circle);
		toggleButtonMediator.registerButton(rectangle);
		toggleButtonMediator.registerButton(elipse);
		toggleButtonMediator.registerButton(square);
		toggleButtonMediator.registerButton(triangle);
		toggleButtonMediator.registerButton(pen);
		toggleButtonMediator.registerButton(move);
		toggleButtonMediator.registerButton(scale);
		toggleButtonMediator.registerButton(select);
	}

	private void registerToggleButtonEvents() {
		rectangle.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getRectangleTool();
			}
		});

		square.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getSquareTool();
			}
		});

		elipse.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getEllipseTool();
			}
		});

		circle.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getCircleTool();
			}
		});

		triangle.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getTriangleTool();
			}
		});

		pen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getLineTool();
			}
		});

		select.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getSelectionTool();
			}
		});

		move.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getMoveTool();
			}
		});

		scale.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedTool = toolRepository.getScaleTool();
			}
		});

		group.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				context.groupElements();
				context.stateChanged();
			}
		});

		ungroup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				context.ungroupElements();
				context.stateChanged();
			}
		});

	}

	private void registerColorPicker() {
		color.setValue(Color.color(selectedColor.getR(), selectedColor.getG(),
				selectedColor.getB()));
		color.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				selectedColor = new RGBColor(color.getValue().getRed(), color
						.getValue().getGreen(), color.getValue().getBlue());
			}
		});
	}

	private void registerCanvasMouseListener() {
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						selectedTool.handleMouseDown(new ToolEvent(
								selectedFilled, selectedColor,
								selectedThickness, e.getSceneX(), e.getSceneY()));
					}
				});

		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						selectedTool.handleMouseMove(new ToolEvent(
								selectedFilled, selectedColor,
								selectedThickness, e.getSceneX(), e.getSceneY()));
					}
				});

		canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						selectedTool.handleMouseUp(new ToolEvent(
								selectedFilled, selectedColor,
								selectedThickness, e.getSceneX(), e.getSceneY()));
					}
				});

	}

}