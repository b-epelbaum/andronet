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

		auto nearVisionForm = gcnew MainForm();
		nearVisionForm->Show();

	}


	System::Void Form1::UpdateForm()
	{
		
	}

}

