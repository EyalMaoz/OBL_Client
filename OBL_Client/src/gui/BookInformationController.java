package gui;

import entities.Book;
import entities.DBMessage;
import entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


import com.jfoenix.controls.JFXButton;

import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class BookInformationController implements IClientUI
{

	@FXML
	private Label bookNameLabel;

	@FXML
	private Label wantedBookLabel;

	@FXML
	private TextArea descreptionPane;

	@FXML
	private ImageView wantedLogo;

	@FXML
	private JFXButton editDetailsBtn;

	@FXML
	private JFXButton deleteBookBtn;

	@FXML
	private JFXButton orderBookBtn;

	@FXML
	private Label authorLabel;

	@FXML
	private Label categoriesLabel;

	@FXML
	private Label catNumLabel;

	private Book bookToShow;


	public void setBookInformation(Book book)
	{
		bookToShow = book;
		bookNameLabel.setText(book.getName());
		String authors = book.getAuthorNameList().toString().replace("[", "").replace("]", "");
		authorLabel.setText(authors);
		String categories = book.getCategories().toString().replace("[", "").replace("]", "");
		categoriesLabel.setText(categories);
		catNumLabel.setText(book.getCatalogNumber());
		if (book.getClassification().equals("wanted"))
		{
			wantedBookLabel.setVisible(true);
			descreptionPane.setVisible(true);
			wantedLogo.setVisible(true);
		} else
		{
			wantedBookLabel.setVisible(false);
			descreptionPane.setVisible(false);
			wantedLogo.setVisible(false);
		}
		System.out.println(book.getDescription());
		descreptionPane.setText(book.getDescription());

	}

	@Override
	public void getMessageFromServer(DBMessage msg)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserLogedIn(User userLoged)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserLogedIn()
	{
		// TODO Auto-generated method stub
		return null;
	}



}
