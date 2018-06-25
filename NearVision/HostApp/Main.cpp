// Vx160.cpp : main project file.

#include "stdafx.h"
#include "Form1.h"



using namespace HostApp;

[STAThreadAttribute]
int main(array<System::String ^> ^args)
{
	// Enabling Windows XP visual effects before any controls are created
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false); 

	// Check if application is already running
	array<System::Diagnostics::Process^>^ process = System::Diagnostics::Process::GetProcesses();
	for (int i=0;i<process->Length;i++)
	{
		if (System::Diagnostics::Process::GetCurrentProcess()->ProcessName == process[i]->ProcessName &&
			System::Diagnostics::Process::GetCurrentProcess()->Id != process[i]->Id)
		{
			SetForegroundWindow((HWND)(process[i]->MainWindowHandle).ToPointer());
			exit(0);
		}
	}

	// Create the main window and run it
	Application::Run(gcnew Form1());
	return 0;
}
