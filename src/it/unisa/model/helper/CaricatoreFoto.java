package it.unisa.model.helper;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;

public class CaricatoreFoto 
{

	private Part fotoDaCaricare;
	
	public CaricatoreFoto(Part file)
	{
		this.setFotoDaCaricare(file);
	}

	public Part getFotoDaCaricare() 
	{
		return fotoDaCaricare;
	}

	public void setFotoDaCaricare(Part fotoDaCaricare)
	{
		this.fotoDaCaricare = fotoDaCaricare;
	}
	
	
	public boolean caricaFotoInPath(String savePath)
	{ 
		boolean done= false;
		
		File fileSaveDir=new File(savePath);
		if(!fileSaveDir.exists())
		{
			fileSaveDir.mkdir();
		}
    
		
		String fileName = this.fotoDaCaricare.getSubmittedFileName();
		if (fileName != null && !fileName.equals("")) 
		{
				
			try
			{
				this.fotoDaCaricare.write(savePath + File.separator + fileName);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		done=true;
			
		return done;
		
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
