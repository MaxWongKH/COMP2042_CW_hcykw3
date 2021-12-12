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

import parts.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DebugConsole extends JDialog implements WindowListener{

    private static final String TITLE = "Debug Console";


    private JFrame owner;
    private DebugPanel debugPanel;
    private GameBoard gameBoard;
    private Wall wall;

    /**
     * DebugConsole creates adds the debugPanel onto the screen
     * @param owner
     * @param wall
     * @param gameBoard
     */
    public DebugConsole(JFrame owner, Wall wall, GameBoard gameBoard){

        this.wall = wall;
        this.owner = owner;
        this.gameBoard = gameBoard;
        initialize();

        debugPanel = new DebugPanel(wall);
        this.add(debugPanel,BorderLayout.CENTER);

        this.pack();
    }

    /**
     * initialize the set the layout of the displayed DebugConsole
     */
    private void initialize(){
        this.setModal(true);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setFocusable(true);
    }

    /***
     * setLocation puts through a formula to get the x and y
     */
    private void setLocation(){
        int x = ((owner.getWidth() - this.getWidth()) / 2) + owner.getX();
        int y = ((owner.getHeight() - this.getHeight()) / 2) + owner.getY();
        this.setLocation(x,y);
    }

    /**
     * windowOpened overrides the window event
     * @param windowEvent window action
     */
    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    /**
     * windowClosing overrides the window event
     * @param windowEvent window action
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        gameBoard.repaint();
    }

    /**
     * windowClosed overrides the window event
     * @param windowEvent window action
     */
    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    /**
     * windowIconified overrides windowEvent
     * @param windowEvent window action
     */
    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    /**
     *windowDeiconified overrides windowEvent
     * @param windowEvent window action
     */
    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    /**
     * windowActivated overrides windowEvent
     * @param windowEvent window action
     */
    @Override
    public void windowActivated(WindowEvent windowEvent) {
        setLocation();
        Ball b = wall.ball;
        debugPanel.setValues(b.getSpeedX(),b.getSpeedY());
    }

    /**
     * windowDeactivated overrides windowEvent
     * @param windowEvent window action
     */
    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
