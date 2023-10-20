/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author casa
 */
public class Pixel implements Serializable {
	private int positionX;
	private int positionY;
	private byte forOrBrackground;
	private Color color;
	public Pixel(int positionX, int positionY, byte forOrBrackground, Color color) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.forOrBrackground = forOrBrackground;
		this.color = color;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public byte getForOrBrackground() {
		return forOrBrackground;
	}
	public void setForOrBrackground(byte forOrBrackground) {
		this.forOrBrackground = forOrBrackground;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Pixel [positionX=" + positionX + ", positionY=" + positionY + ", forOrBrackground=" + forOrBrackground
				+ ", color=" + color + "]";
	}
	
	

}
