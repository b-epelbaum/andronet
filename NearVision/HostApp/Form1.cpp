#include "StdAfx.h"
#include "Form1.h"


using namespace System::Globalization;
using namespace NearVision;

namespace HostApp
{
	Form1::Form1(void)
	{
		InitializeComponent();
		//
		//TODO: Add the constructor code here
		//

		try
		{
			auto nearVisionForm = gcnew NearVisionForm();
			nearVisionForm->Show();
		}
		catch(NearVisionException^ e)
		{
			MessageBox::Show("Exception caught : "+ e->InnerException->Message);
		}
	}


	System::Void Form1::UpdateForm()
	{
		
	}

}

