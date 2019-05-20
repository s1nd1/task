import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.awt.*;
import java.sql.Time;
import java.util.concurrent.ThreadLocalRandom;

public class ControlerWindow {

    @FXML
    private Button buttonStart;

    @FXML
    private ImageView oblako;

    @FXML
    private ImageView luwa;

    @FXML
    private ImageView dojd;

    @FXML
    private Button buttonStop;

    private Thread rabota =new Thread(new Thread1());;

    @FXML
    void buttonAct(ActionEvent event) {
        VisibleImage(true);
        buttonStart.setVisible(false);
        buttonStop.setVisible(true);
        rabota.run();
    }

    @FXML
    void buttonStopAct(ActionEvent event) {
       VisibleImage(false);
        buttonStart.setVisible(true);
        buttonStop.setVisible(false);
        rabota.stop();

    }
    void VisibleImage(boolean a){
        oblako.setVisible(a);
        dojd.setVisible(a);
        luwa.setVisible(a);
    }
    public class Thread1 implements Runnable {
        @Override
        public void run() {
            dojd.setVisible(true);
            FadeTransition fadeDojd= new FadeTransition(Duration.millis(1000),dojd);
            fadeDojd.setFromValue(100.0);
            fadeDojd.setToValue(0.0);
            fadeDojd.setCycleCount(Timeline.INDEFINITE);
            fadeDojd.setAutoReverse(true);

            KeyValue heigth =new KeyValue(oblako.fitHeightProperty(), 100);
            KeyValue width =new KeyValue(oblako.fitWidthProperty(), 100);
            KeyFrame keyFrame= new KeyFrame(Duration.millis(2000), heigth, width);

            KeyValue heigthdojd =new KeyValue(dojd.xProperty(), 10);
            KeyValue widthdojd =new KeyValue(dojd.yProperty(), 150);
            KeyFrame keyFramedojd= new KeyFrame(Duration.millis(2000), heigthdojd, widthdojd);

            KeyValue heigthluwa =new KeyValue(luwa.fitHeightProperty(), 300);
            KeyValue widthluwa =new KeyValue(luwa.fitWidthProperty(), 300);
            KeyFrame keyFrameluwa= new KeyFrame(Duration.millis(2000), heigthluwa, widthluwa);

            Timeline timelineoblako= new Timeline();
            timelineoblako.setCycleCount(Timeline.INDEFINITE);
            timelineoblako.setAutoReverse(true);
            timelineoblako.getKeyFrames().addAll(keyFrame);
            Timeline timelinedojd= new Timeline();
            timelinedojd.setCycleCount(Timeline.INDEFINITE);
            timelinedojd.setAutoReverse(true);
            timelineoblako.getKeyFrames().addAll(keyFramedojd);
            timelinedojd.play();
            Timeline timelineluwa= new Timeline();
            timelineluwa.setCycleCount(Timeline.INDEFINITE);
            timelineluwa.setAutoReverse(true);
            timelineluwa.getKeyFrames().addAll(keyFrameluwa);
            timelineluwa.play();
            timelinedojd.play();
            timelineoblako.play();
            fadeDojd.play();
            }
        }
    }

