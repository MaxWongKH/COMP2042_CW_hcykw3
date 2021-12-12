/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main;

import highscore.HighScore;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class HomeMenu extends JLayeredPane {

    private JLabel menuBackground = new JLabel();
    private Image mainMenuBackground = new ImageLoader(ImageLoader.mainMenuBackground).getImage();
    private ImageIcon menuIcon = new ImageIcon(mainMenuBackground);

    private JLabel infoBackground = new JLabel();
    private Image infoPage = new ImageLoader(ImageLoader.infoBackground).getImage();
    private ImageIcon infoIcon = new ImageIcon(infoPage);

    private JLabel hsBackground = new JLabel();
    private Image highScoreBackground = new ImageLoader(ImageLoader.highScoreBackground).getImage();
    private ImageIcon hsIcon = new ImageIcon(highScoreBackground);

    private JLabel exitInfo = new JLabel();
    private JLabel exitHS = new JLabel();

    private JLabel startButton = new JLabel();
    private Image startButtonBefore = new ImageLoader(ImageLoader.startButtonBefore).getImage();
    private ImageIcon startBeforeIcon = new ImageIcon(startButtonBefore);
    private Image startButtonAfter = new ImageLoader(ImageLoader.startButtonAfter).getImage();
    private ImageIcon startAfterIcon = new ImageIcon(startButtonAfter);

    private JLabel infoButton = new JLabel();
    private Image infoButtonBefore = new ImageLoader(ImageLoader.infoButtonBefore).getImage();
    private ImageIcon infoBeforeIcon = new ImageIcon(infoButtonBefore);
    private Image infoButtonAfter = new ImageLoader(ImageLoader.infoButtonAfter).getImage();
    private ImageIcon infoAfterIcon  = new ImageIcon(infoButtonAfter);

    private JLabel highScoreButton = new JLabel();
    private Image highScoreButtonBefore = new ImageLoader(ImageLoader.scoreButtonBefore).getImage();
    private ImageIcon hsBeforeIcon = new ImageIcon(highScoreButtonBefore);
    private Image highScoreButtonAfter = new ImageLoader(ImageLoader.scoreButtonAfter).getImage();
    private ImageIcon hsAfterIcon = new ImageIcon(highScoreButtonAfter);

    private JLabel exitButton = new JLabel();
    private Image exitButtonBefore = new ImageLoader(ImageLoader.exitButtonBefore).getImage();
    private ImageIcon exitBeforeIcon = new ImageIcon(exitButtonBefore);
    private Image exitButtonAfter = new ImageLoader(ImageLoader.exitButtonAfter).getImage();
    private ImageIcon exitAfterIcon = new ImageIcon(exitButtonAfter);

    JTextArea highScoreText = new JTextArea();


    public HomeMenu(GameFrame owner,Dimension area){

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setLayout(null);
        this.setPreferredSize(area);

        menuBackground.setBounds(0,0,1000,750);
        menuBackground.setIcon(menuIcon);

        startButton.setBounds(397,210,206,65);
        startButton.setIcon(startBeforeIcon);
        startButton.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();

                if(startButton.contains(p)){
                    owner.enableGameBoard();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Point p = e.getPoint();

                if(startButton.contains(p)){
                    startButton.setIcon(startAfterIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point p = e.getPoint();
                startButton.setIcon(startBeforeIcon);
                if(startButton.contains(p)){
                    owner.enableGameBoard();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();

                if(startButton.contains(p)){
                    startButton.setIcon(startAfterIcon);
                }else{
                    startButton.setIcon(startBeforeIcon);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        infoButton.setBounds(397,280,206,65);
        infoButton.setIcon(infoBeforeIcon);
        infoButton.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();

                if(infoButton.contains(p)){
                    enableInfo();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Point p = e.getPoint();

                if(infoButton.contains(p)){
                        infoButton.setIcon(infoAfterIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point p = e.getPoint();

                infoButton.setIcon(infoBeforeIcon);
                if(infoButton.contains(p)){
                    enableInfo();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();

                if(infoButton.contains(p)){
                    infoButton.setIcon(infoAfterIcon);
                }else{
                    infoButton.setIcon(infoBeforeIcon);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


        exitButton.setBounds(397,350,206,65);
        //exitButton.setBounds((this.getWidth()/4)*3-exitButtonBefore.getWidth(null)/2,(this.getHeight()/4)*3-exitButtonBefore.getHeight(null)/2,206,65);
        exitButton.setIcon(exitBeforeIcon);
        exitButton.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitButton.contains(p)){
                    System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitButton.contains(p)){
                    exitButton.setIcon(exitAfterIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                exitButton.setIcon(exitBeforeIcon);
                if(exitButton.contains(p)){
                    System.exit(0);
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {


            }


            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitButton.contains(p)){
                    exitButton.setIcon(exitAfterIcon);
                }else{
                    exitButton.setIcon(exitBeforeIcon);
                }
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });


        highScoreButton.setBounds(397,420,206,65);
        highScoreButton.setIcon(hsBeforeIcon);
        highScoreButton.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(highScoreButton.contains(p)){
                    try {
                        enableHighScore();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(highScoreButton.contains(p)){
                    highScoreButton.setIcon(hsAfterIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                highScoreButton.setIcon(hsBeforeIcon);
                if(highScoreButton.contains(p)){
                    try {
                        enableHighScore();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {


            }


            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(highScoreButton.contains(p)){
                    highScoreButton.setIcon(hsAfterIcon);
                }else{
                    highScoreButton.setIcon(hsBeforeIcon);
                }
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });

        enableMainMenu();

    }

    public void enableMainMenu(){
        this.add(menuBackground, DEFAULT_LAYER);
        this.add(startButton, PALETTE_LAYER);
        this.add(exitButton, PALETTE_LAYER);
        this.add(highScoreButton, PALETTE_LAYER);
        this.add(infoButton, PALETTE_LAYER);
    }


    public void enableInfo(){
        this.remove(menuBackground);
        this.remove(startButton);
        this.remove(infoButton);
        this.remove(exitButton);
        this.remove(highScoreButton);

        infoBackground.setBounds(0,0,1000,750);
        infoBackground.setIcon(infoIcon);

        exitInfo.setBounds(794,690,206,65);
        exitInfo.setIcon(exitBeforeIcon);
        exitInfo.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitInfo.contains(p)){
                    remove(infoBackground);
                    remove(exitInfo);
                    enableMainMenu();

                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitInfo.contains(p)){
                    exitInfo.setIcon(exitAfterIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                exitInfo.setIcon(exitBeforeIcon);
                if(exitInfo.contains(p)){
                    remove(infoBackground);
                    remove(exitInfo);
                    enableMainMenu();


                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {


            }


            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitInfo.contains(p)){
                    exitInfo.setIcon(exitAfterIcon);
                }else{
                    exitInfo.setIcon(exitBeforeIcon);
                }
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });

        this.add(infoBackground,POPUP_LAYER);
        this.add(exitInfo, DRAG_LAYER);


    }


    public void enableHighScore() throws IOException {
        this.remove(menuBackground);
        this.remove(startButton);
        this.remove(infoButton);
        this.remove(exitButton);
        this.remove(highScoreButton);

        hsBackground.setBounds(0,0,1000,750);
        hsBackground.setIcon(hsIcon);
        this.add(hsBackground, POPUP_LAYER);

        exitHS.setBounds(794,690,206,65);
        exitHS.setIcon(exitBeforeIcon);
        exitHS.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitHS.contains(p)){
                    remove(hsBackground);
                    enableMainMenu();
                    remove(exitHS);
                    remove(highScoreText);

                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitHS.contains(p)){
                    exitHS.setIcon(exitAfterIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                exitHS.setIcon(exitBeforeIcon);
                if(exitHS.contains(p)){
                    remove(hsBackground);
                    enableMainMenu();
                    remove(exitHS);
                    remove(highScoreText);

                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {


            }


            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                Point p = mouseEvent.getPoint();

                if(exitHS.contains(p)){
                    exitHS.setIcon(exitAfterIcon);
                }else{
                    exitHS.setIcon(exitBeforeIcon);
                }
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });


        this.add(exitHS, DRAG_LAYER);

        highScoreText.setSize(300, 200);
        highScoreText.setLocation(300,200);

        HighScore hs = new HighScore();
        highScoreText.setText(hs.getHighscoreString());
        this.add(highScoreText, DRAG_LAYER);

    }

}
