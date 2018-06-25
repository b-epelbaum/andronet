#pragma once

using namespace System::Globalization;

namespace HostApp
{

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;


	/// <summary>
	/// Summary for Form1
	/// </summary>
	public ref class Form1 : public System::Windows::Forms::Form
	{
	public:
		Form1(void);

	protected:
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		~Form1()
		{
		}


	
	private: System::Windows::Forms::PictureBox^  m_Cam0PictureBox;
	private: System::Windows::Forms::PictureBox^  m_Cam1PictureBox;
	private: System::Windows::Forms::PictureBox^  m_Cam3PictureBox;
	private: bool m_CamerasDetected;




	private:
		System::Windows::Forms::PictureBox^  m_Cam2PictureBox;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::TextBox^  m_Cam0IdTextBox;
	private: System::Windows::Forms::TextBox^  m_Cam1IdTextBox;
	private: System::Windows::Forms::TextBox^  m_Cam3IdTextBox;
	private: System::Windows::Forms::TextBox^  m_Cam2IdTextBox;
	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::TextBox^  m_FpsCam0TextBox;
	private: System::Windows::Forms::TextBox^  m_FpsCam1TextBox;
	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::TextBox^  m_FpsCam2TextBox;
	private: System::Windows::Forms::Label^  label7;
	private: System::Windows::Forms::TextBox^  m_FpsCam3TextBox;
	private: System::Windows::Forms::Label^  label8;
	private: System::Windows::Forms::Timer^  m_Timer;
	private: System::Windows::Forms::ListBox^  m_StatusListBox;
	private: System::Windows::Forms::Button^  m_ReconnectButton;
	private: System::Windows::Forms::Button^  ClearButton;
	private: System::Windows::Forms::Label^  label9;
	private: System::Windows::Forms::Label^  label10;
	private: System::Windows::Forms::Label^  label11;
	private: System::Windows::Forms::Label^  label12;
	private: System::Windows::Forms::TextBox^  Clients1TextBox;
	private: System::Windows::Forms::TextBox^  Clients0TextBox;
	private: System::Windows::Forms::TextBox^  Clients2TextBox;
	private: System::Windows::Forms::TextBox^  Clients3TextBox;
	private: System::Windows::Forms::Button^  m_TestButton;
	private: System::Windows::Forms::CheckBox^  m_CheckLimitsThreadCheckBox;
	private: System::Windows::Forms::Button^  m_ControllerButton;
	private: System::Windows::Forms::Button^  m_MeasureButton;
	private: System::Windows::Forms::Button^  m_ImageButton;
	private: System::Windows::Forms::TextBox^  m_Cam0XTextBox;
	private: System::Windows::Forms::Label^  label13;
	private: System::Windows::Forms::TextBox^  m_Cam0YTextBox;
	private: System::Windows::Forms::Label^  label14;
	private: System::Windows::Forms::TextBox^  m_Cam2YTextBox;
	private: System::Windows::Forms::Label^  label15;
	private: System::Windows::Forms::TextBox^  m_Cam2XTextBox;
	private: System::Windows::Forms::Label^  label16;
	private: System::Windows::Forms::TextBox^  m_Cam3YTextBox;
	private: System::Windows::Forms::Label^  label17;
	private: System::Windows::Forms::TextBox^  m_Cam3XTextBox;
	private: System::Windows::Forms::Label^  label18;
	private: System::Windows::Forms::TextBox^  m_Cam1YTextBox;
	private: System::Windows::Forms::Label^  label19;
	private: System::Windows::Forms::TextBox^  m_Cam1XTextBox;
	private: System::Windows::Forms::Label^  label20;
	private: System::Windows::Forms::Button^  m_SaveRightShButton;
	private: System::Windows::Forms::Button^  m_SaveLeftShButton;
	private: System::Windows::Forms::Button^  m_SaveRightVisuButton;
	private: System::Windows::Forms::Button^  m_SaveLeftVisuButton; 
	private: System::Windows::Forms::Label^  label21;
	private: System::Windows::Forms::NumericUpDown^  m_RightShGainNumericUpDown;
	private: System::Windows::Forms::NumericUpDown^  m_LeftShGainNumericUpDown;
	private: System::Windows::Forms::Label^  label22;
	private: System::Windows::Forms::NumericUpDown^  m_RightVisuGainNumericUpDown;
	private: System::Windows::Forms::Label^  label23;
	private: System::Windows::Forms::NumericUpDown^  m_LeftVisuGainNumericUpDown;
	private: System::Windows::Forms::Label^  label24;
	private: System::Windows::Forms::Button^  m_ReconectNoResetButton;
	private: System::Windows::Forms::Button^  m_CalibrationButton;
	private: System::Windows::Forms::Button^  m_buttonPrintTicket;
	private: System::Windows::Forms::Button^  SaveLogButton;
	private: System::Windows::Forms::Button^  m_buttonPatientMange;
	private: System::Windows::Forms::Button^  m_ChinRestUpButton;
	private: System::Windows::Forms::Button^  m_ChinRestDownButton;
	private: System::Windows::Forms::Button^  ArtificialEyeButton;
	private: System::Windows::Forms::Button^  m_CalibrationBackupButton;
	private: System::Windows::Forms::Button^  m_RestoreCalibrationBackupButton;
	private: System::Windows::Forms::Button^  AtpButton;
			//	private: System::Windows::Forms::Button^ NewNvButton;
//private: System::Windows::Forms::Button^ NewNvStopButton;
	private: System::Windows::Forms::Button^  NewMacAddressButton;
	private: System::Windows::Forms::Button^  FirstEncryptionButton;
private: System::Windows::Forms::Button^  ShutDownButton;

	private: System::Windows::Forms::Button^  UpgradeSoftwareButton;
	private: System::Windows::Forms::CheckBox^  TestsThreadCheckBox;
	private: System::Windows::Forms::Label^  label25;
	private: System::Windows::Forms::Label^  label26;
	private: System::Windows::Forms::TextBox^  RightContrastTextBox;
	private: System::Windows::Forms::TextBox^  LeftContrastTextBox;
	private: System::Windows::Forms::CheckBox^  ShowContrastCheckBox;

		
	private: System::Windows::Forms::Button^  SendToTabletButton;


	private: System::ComponentModel::IContainer^  components;
	private:
	private:
		/// <summary>
		/// Required designer variable.
		/// </summary>


#pragma region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		void InitializeComponent(void)
		{
			this->components = (gcnew System::ComponentModel::Container());
			this->m_Cam0PictureBox = (gcnew System::Windows::Forms::PictureBox());
			this->m_Cam1PictureBox = (gcnew System::Windows::Forms::PictureBox());
			this->m_Cam3PictureBox = (gcnew System::Windows::Forms::PictureBox());
			this->m_Cam2PictureBox = (gcnew System::Windows::Forms::PictureBox());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->m_Cam0IdTextBox = (gcnew System::Windows::Forms::TextBox());
			this->m_Cam1IdTextBox = (gcnew System::Windows::Forms::TextBox());
			this->m_Cam3IdTextBox = (gcnew System::Windows::Forms::TextBox());
			this->m_Cam2IdTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->m_FpsCam0TextBox = (gcnew System::Windows::Forms::TextBox());
			this->m_FpsCam1TextBox = (gcnew System::Windows::Forms::TextBox());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->m_FpsCam2TextBox = (gcnew System::Windows::Forms::TextBox());
			this->label7 = (gcnew System::Windows::Forms::Label());
			this->m_FpsCam3TextBox = (gcnew System::Windows::Forms::TextBox());
			this->label8 = (gcnew System::Windows::Forms::Label());
			this->m_Timer = (gcnew System::Windows::Forms::Timer(this->components));
			this->m_StatusListBox = (gcnew System::Windows::Forms::ListBox());
			this->m_ReconnectButton = (gcnew System::Windows::Forms::Button());
			this->ClearButton = (gcnew System::Windows::Forms::Button());
			this->label9 = (gcnew System::Windows::Forms::Label());
			this->label10 = (gcnew System::Windows::Forms::Label());
			this->label11 = (gcnew System::Windows::Forms::Label());
			this->label12 = (gcnew System::Windows::Forms::Label());
			this->Clients1TextBox = (gcnew System::Windows::Forms::TextBox());
			this->Clients0TextBox = (gcnew System::Windows::Forms::TextBox());
			this->Clients2TextBox = (gcnew System::Windows::Forms::TextBox());
			this->Clients3TextBox = (gcnew System::Windows::Forms::TextBox());
			this->m_TestButton = (gcnew System::Windows::Forms::Button());
			this->m_CheckLimitsThreadCheckBox = (gcnew System::Windows::Forms::CheckBox());
			this->m_ControllerButton = (gcnew System::Windows::Forms::Button());
			this->m_MeasureButton = (gcnew System::Windows::Forms::Button());
			this->m_ImageButton = (gcnew System::Windows::Forms::Button());
			this->m_Cam0XTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label13 = (gcnew System::Windows::Forms::Label());
			this->m_Cam0YTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label14 = (gcnew System::Windows::Forms::Label());
			this->m_Cam2YTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label15 = (gcnew System::Windows::Forms::Label());
			this->m_Cam2XTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label16 = (gcnew System::Windows::Forms::Label());
			this->m_Cam3YTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label17 = (gcnew System::Windows::Forms::Label());
			this->m_Cam3XTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label18 = (gcnew System::Windows::Forms::Label());
			this->m_Cam1YTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label19 = (gcnew System::Windows::Forms::Label());
			this->m_Cam1XTextBox = (gcnew System::Windows::Forms::TextBox());
			this->label20 = (gcnew System::Windows::Forms::Label());
			this->m_SaveRightShButton = (gcnew System::Windows::Forms::Button());
			this->m_SaveLeftShButton = (gcnew System::Windows::Forms::Button());
			this->m_SaveRightVisuButton = (gcnew System::Windows::Forms::Button());
			this->m_SaveLeftVisuButton = (gcnew System::Windows::Forms::Button());
			this->label21 = (gcnew System::Windows::Forms::Label());
			this->m_RightShGainNumericUpDown = (gcnew System::Windows::Forms::NumericUpDown());
			this->m_LeftShGainNumericUpDown = (gcnew System::Windows::Forms::NumericUpDown());
			this->label22 = (gcnew System::Windows::Forms::Label());
			this->m_RightVisuGainNumericUpDown = (gcnew System::Windows::Forms::NumericUpDown());
			this->label23 = (gcnew System::Windows::Forms::Label());
			this->m_LeftVisuGainNumericUpDown = (gcnew System::Windows::Forms::NumericUpDown());
			this->label24 = (gcnew System::Windows::Forms::Label());
			this->m_ReconectNoResetButton = (gcnew System::Windows::Forms::Button());
			this->m_CalibrationButton = (gcnew System::Windows::Forms::Button());
			this->m_buttonPrintTicket = (gcnew System::Windows::Forms::Button());
			this->SaveLogButton = (gcnew System::Windows::Forms::Button());
			this->m_buttonPatientMange = (gcnew System::Windows::Forms::Button());
			this->m_ChinRestUpButton = (gcnew System::Windows::Forms::Button());
			this->m_ChinRestDownButton = (gcnew System::Windows::Forms::Button());
			this->ArtificialEyeButton = (gcnew System::Windows::Forms::Button());
			this->m_CalibrationBackupButton = (gcnew System::Windows::Forms::Button());
			this->m_RestoreCalibrationBackupButton = (gcnew System::Windows::Forms::Button());
			this->AtpButton = (gcnew System::Windows::Forms::Button());
			this->NewMacAddressButton = (gcnew System::Windows::Forms::Button());
			this->FirstEncryptionButton = (gcnew System::Windows::Forms::Button());
			this->ShutDownButton = (gcnew System::Windows::Forms::Button());
			this->UpgradeSoftwareButton = (gcnew System::Windows::Forms::Button());
			this->TestsThreadCheckBox = (gcnew System::Windows::Forms::CheckBox());
			this->label25 = (gcnew System::Windows::Forms::Label());
			this->label26 = (gcnew System::Windows::Forms::Label());
			this->RightContrastTextBox = (gcnew System::Windows::Forms::TextBox());
			this->LeftContrastTextBox = (gcnew System::Windows::Forms::TextBox());
			this->ShowContrastCheckBox = (gcnew System::Windows::Forms::CheckBox());
			this->SendToTabletButton = (gcnew System::Windows::Forms::Button());
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam0PictureBox))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam1PictureBox))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam3PictureBox))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam2PictureBox))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_RightShGainNumericUpDown))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_LeftShGainNumericUpDown))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_RightVisuGainNumericUpDown))->BeginInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_LeftVisuGainNumericUpDown))->BeginInit();
			this->SuspendLayout();
			// 
			// m_Cam0PictureBox
			// 
			this->m_Cam0PictureBox->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_Cam0PictureBox->Location = System::Drawing::Point(26, 53);
			this->m_Cam0PictureBox->Name = L"m_Cam0PictureBox";
			this->m_Cam0PictureBox->Size = System::Drawing::Size(256, 320);
			this->m_Cam0PictureBox->TabIndex = 0;
			this->m_Cam0PictureBox->TabStop = false;

			// 
			// m_Cam1PictureBox
			// 
			this->m_Cam1PictureBox->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_Cam1PictureBox->Location = System::Drawing::Point(599, 53);
			this->m_Cam1PictureBox->Name = L"m_Cam1PictureBox";
			this->m_Cam1PictureBox->Size = System::Drawing::Size(256, 320);
			this->m_Cam1PictureBox->TabIndex = 1;
			this->m_Cam1PictureBox->TabStop = false;

			// 
			// m_Cam3PictureBox
			// 
			this->m_Cam3PictureBox->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_Cam3PictureBox->Location = System::Drawing::Point(602, 455);
			this->m_Cam3PictureBox->Name = L"m_Cam3PictureBox";
			this->m_Cam3PictureBox->Size = System::Drawing::Size(320, 256);
			this->m_Cam3PictureBox->TabIndex = 3;
			this->m_Cam3PictureBox->TabStop = false;

			// 
			// m_Cam2PictureBox
			// 
			this->m_Cam2PictureBox->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_Cam2PictureBox->Location = System::Drawing::Point(29, 455);
			this->m_Cam2PictureBox->Name = L"m_Cam2PictureBox";
			this->m_Cam2PictureBox->Size = System::Drawing::Size(320, 256);
			this->m_Cam2PictureBox->TabIndex = 2;
			this->m_Cam2PictureBox->TabStop = false;

			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(26, 30);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(21, 13);
			this->label1->TabIndex = 4;
			this->label1->Text = L"ID:";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(601, 30);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(21, 13);
			this->label2->TabIndex = 5;
			this->label2->Text = L"ID:";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(604, 426);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(21, 13);
			this->label3->TabIndex = 7;
			this->label3->Text = L"ID:";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Location = System::Drawing::Point(32, 426);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(21, 13);
			this->label4->TabIndex = 6;
			this->label4->Text = L"ID:";
			// 
			// m_Cam0IdTextBox
			// 
			this->m_Cam0IdTextBox->Location = System::Drawing::Point(50, 23);
			this->m_Cam0IdTextBox->Name = L"m_Cam0IdTextBox";
			this->m_Cam0IdTextBox->ReadOnly = true;
			this->m_Cam0IdTextBox->Size = System::Drawing::Size(127, 20);
			this->m_Cam0IdTextBox->TabIndex = 8;
			// 
			// m_Cam1IdTextBox
			// 
			this->m_Cam1IdTextBox->Location = System::Drawing::Point(624, 23);
			this->m_Cam1IdTextBox->Name = L"m_Cam1IdTextBox";
			this->m_Cam1IdTextBox->ReadOnly = true;
			this->m_Cam1IdTextBox->Size = System::Drawing::Size(127, 20);
			this->m_Cam1IdTextBox->TabIndex = 9;
			// 
			// m_Cam3IdTextBox
			// 
			this->m_Cam3IdTextBox->Location = System::Drawing::Point(627, 419);
			this->m_Cam3IdTextBox->Name = L"m_Cam3IdTextBox";
			this->m_Cam3IdTextBox->ReadOnly = true;
			this->m_Cam3IdTextBox->Size = System::Drawing::Size(127, 20);
			this->m_Cam3IdTextBox->TabIndex = 11;
			// 
			// m_Cam2IdTextBox
			// 
			this->m_Cam2IdTextBox->Location = System::Drawing::Point(56, 419);
			this->m_Cam2IdTextBox->Name = L"m_Cam2IdTextBox";
			this->m_Cam2IdTextBox->ReadOnly = true;
			this->m_Cam2IdTextBox->Size = System::Drawing::Size(127, 20);
			this->m_Cam2IdTextBox->TabIndex = 10;
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Location = System::Drawing::Point(184, 30);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(30, 13);
			this->label5->TabIndex = 12;
			this->label5->Text = L"FPS:";
			// 
			// m_FpsCam0TextBox
			// 
			this->m_FpsCam0TextBox->Location = System::Drawing::Point(217, 23);
			this->m_FpsCam0TextBox->Name = L"m_FpsCam0TextBox";
			this->m_FpsCam0TextBox->ReadOnly = true;
			this->m_FpsCam0TextBox->Size = System::Drawing::Size(40, 20);
			this->m_FpsCam0TextBox->TabIndex = 13;
			// 
			// m_FpsCam1TextBox
			// 
			this->m_FpsCam1TextBox->Location = System::Drawing::Point(790, 23);
			this->m_FpsCam1TextBox->Name = L"m_FpsCam1TextBox";
			this->m_FpsCam1TextBox->ReadOnly = true;
			this->m_FpsCam1TextBox->Size = System::Drawing::Size(40, 20);
			this->m_FpsCam1TextBox->TabIndex = 15;
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Location = System::Drawing::Point(757, 30);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(30, 13);
			this->label6->TabIndex = 14;
			this->label6->Text = L"FPS:";
			// 
			// m_FpsCam2TextBox
			// 
			this->m_FpsCam2TextBox->Location = System::Drawing::Point(224, 419);
			this->m_FpsCam2TextBox->Name = L"m_FpsCam2TextBox";
			this->m_FpsCam2TextBox->ReadOnly = true;
			this->m_FpsCam2TextBox->Size = System::Drawing::Size(40, 20);
			this->m_FpsCam2TextBox->TabIndex = 17;
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Location = System::Drawing::Point(191, 426);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(30, 13);
			this->label7->TabIndex = 16;
			this->label7->Text = L"FPS:";
			// 
			// m_FpsCam3TextBox
			// 
			this->m_FpsCam3TextBox->Location = System::Drawing::Point(794, 419);
			this->m_FpsCam3TextBox->Name = L"m_FpsCam3TextBox";
			this->m_FpsCam3TextBox->ReadOnly = true;
			this->m_FpsCam3TextBox->Size = System::Drawing::Size(40, 20);
			this->m_FpsCam3TextBox->TabIndex = 19;
			// 
			// label8
			// 
			this->label8->AutoSize = true;
			this->label8->Location = System::Drawing::Point(761, 426);
			this->label8->Name = L"label8";
			this->label8->Size = System::Drawing::Size(30, 13);
			this->label8->TabIndex = 18;
			this->label8->Text = L"FPS:";
			// 
			// m_Timer
			// 
			
			// 
			// m_StatusListBox
			// 
			this->m_StatusListBox->FormattingEnabled = true;
			this->m_StatusListBox->Items->AddRange(gcnew cli::array< System::Object^  >(10) {
				L"Start Left Visu Camera OK", L"Start Right Visu Camera OK",
					L"Start Left SH Camera OK", L"Start Right SHCamera OK", L"Motors Reset OK", L"Intrenal Printer OK", L"Illumination OK", L"Homing OK",
					L"Load Calibration Files OK", L"Load Param Files OK"
			});
			this->m_StatusListBox->Location = System::Drawing::Point(26, 750);
			this->m_StatusListBox->Name = L"m_StatusListBox";
			this->m_StatusListBox->ScrollAlwaysVisible = true;
			this->m_StatusListBox->Size = System::Drawing::Size(1309, 95);
			this->m_StatusListBox->TabIndex = 20;
			this->m_StatusListBox->TabStop = false;
			// 
			// m_ReconnectButton
			// 
			this->m_ReconnectButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_ReconnectButton->Location = System::Drawing::Point(1099, 12);
			this->m_ReconnectButton->Name = L"m_ReconnectButton";
			this->m_ReconnectButton->Size = System::Drawing::Size(75, 23);
			this->m_ReconnectButton->TabIndex = 21;
			this->m_ReconnectButton->Text = L"Reconnect";
			this->m_ReconnectButton->UseVisualStyleBackColor = false;

			// 
			// ClearButton
			// 
			this->ClearButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClearButton->Location = System::Drawing::Point(1103, 687);
			this->ClearButton->Name = L"ClearButton";
			this->ClearButton->Size = System::Drawing::Size(75, 23);
			this->ClearButton->TabIndex = 22;
			this->ClearButton->Text = L"Clear";

			// 
			// label9
			// 
			this->label9->AutoSize = true;
			this->label9->Location = System::Drawing::Point(263, 30);
			this->label9->Name = L"label9";
			this->label9->Size = System::Drawing::Size(38, 13);
			this->label9->TabIndex = 23;
			this->label9->Text = L"Clients";
			// 
			// label10
			// 
			this->label10->AutoSize = true;
			this->label10->Location = System::Drawing::Point(270, 426);
			this->label10->Name = L"label10";
			this->label10->Size = System::Drawing::Size(38, 13);
			this->label10->TabIndex = 24;
			this->label10->Text = L"Clients";
			// 
			// label11
			// 
			this->label11->AutoSize = true;
			this->label11->Location = System::Drawing::Point(840, 426);
			this->label11->Name = L"label11";
			this->label11->Size = System::Drawing::Size(38, 13);
			this->label11->TabIndex = 25;
			this->label11->Text = L"Clients";
			// 
			// label12
			// 
			this->label12->AutoSize = true;
			this->label12->Location = System::Drawing::Point(836, 30);
			this->label12->Name = L"label12";
			this->label12->Size = System::Drawing::Size(38, 13);
			this->label12->TabIndex = 26;
			this->label12->Text = L"Clients";
			// 
			// Clients1TextBox
			// 
			this->Clients1TextBox->Location = System::Drawing::Point(879, 23);
			this->Clients1TextBox->Name = L"Clients1TextBox";
			this->Clients1TextBox->ReadOnly = true;
			this->Clients1TextBox->Size = System::Drawing::Size(40, 20);
			this->Clients1TextBox->TabIndex = 27;
			// 
			// Clients0TextBox
			// 
			this->Clients0TextBox->Location = System::Drawing::Point(303, 23);
			this->Clients0TextBox->Name = L"Clients0TextBox";
			this->Clients0TextBox->ReadOnly = true;
			this->Clients0TextBox->Size = System::Drawing::Size(40, 20);
			this->Clients0TextBox->TabIndex = 28;
			// 
			// Clients2TextBox
			// 
			this->Clients2TextBox->Location = System::Drawing::Point(310, 419);
			this->Clients2TextBox->Name = L"Clients2TextBox";
			this->Clients2TextBox->ReadOnly = true;
			this->Clients2TextBox->Size = System::Drawing::Size(40, 20);
			this->Clients2TextBox->TabIndex = 29;
			// 
			// Clients3TextBox
			// 
			this->Clients3TextBox->Location = System::Drawing::Point(883, 419);
			this->Clients3TextBox->Name = L"Clients3TextBox";
			this->Clients3TextBox->ReadOnly = true;
			this->Clients3TextBox->Size = System::Drawing::Size(40, 20);
			this->Clients3TextBox->TabIndex = 30;
			// 
			// m_TestButton
			// 
			this->m_TestButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_TestButton->Location = System::Drawing::Point(1180, 96);
			this->m_TestButton->Name = L"m_TestButton";
			this->m_TestButton->Size = System::Drawing::Size(75, 23);
			this->m_TestButton->TabIndex = 31;
			this->m_TestButton->Text = L"Test";
			this->m_TestButton->UseVisualStyleBackColor = false;
			// 
			// m_CheckLimitsThreadCheckBox
			// 
			this->m_CheckLimitsThreadCheckBox->AutoSize = true;
			this->m_CheckLimitsThreadCheckBox->BackColor = System::Drawing::SystemColors::Control;
			this->m_CheckLimitsThreadCheckBox->Checked = true;
			this->m_CheckLimitsThreadCheckBox->CheckState = System::Windows::Forms::CheckState::Checked;
			this->m_CheckLimitsThreadCheckBox->Location = System::Drawing::Point(1058, 73);
			this->m_CheckLimitsThreadCheckBox->Name = L"m_CheckLimitsThreadCheckBox";
			this->m_CheckLimitsThreadCheckBox->Size = System::Drawing::Size(123, 17);
			this->m_CheckLimitsThreadCheckBox->TabIndex = 32;
			this->m_CheckLimitsThreadCheckBox->Text = L"Check Limits Thread";
			this->m_CheckLimitsThreadCheckBox->UseVisualStyleBackColor = false;

			// 
			// m_ControllerButton
			// 
			this->m_ControllerButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_ControllerButton->Location = System::Drawing::Point(1099, 96);
			this->m_ControllerButton->Name = L"m_ControllerButton";
			this->m_ControllerButton->Size = System::Drawing::Size(75, 23);
			this->m_ControllerButton->TabIndex = 33;
			this->m_ControllerButton->Text = L"Controller...";
			this->m_ControllerButton->UseVisualStyleBackColor = false;

			// 
			// m_MeasureButton
			// 
			this->m_MeasureButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_MeasureButton->Location = System::Drawing::Point(1099, 125);
			this->m_MeasureButton->Name = L"m_MeasureButton";
			this->m_MeasureButton->Size = System::Drawing::Size(75, 23);
			this->m_MeasureButton->TabIndex = 34;
			this->m_MeasureButton->Text = L"Measure...";
			this->m_MeasureButton->UseVisualStyleBackColor = false;

			// 
			// m_ImageButton
			// 
			this->m_ImageButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_ImageButton->Location = System::Drawing::Point(1099, 154);
			this->m_ImageButton->Name = L"m_ImageButton";
			this->m_ImageButton->Size = System::Drawing::Size(75, 23);
			this->m_ImageButton->TabIndex = 35;
			this->m_ImageButton->Text = L"Image...";
			this->m_ImageButton->UseVisualStyleBackColor = false;

			// 
			// m_Cam0XTextBox
			// 
			this->m_Cam0XTextBox->Location = System::Drawing::Point(319, 70);
			this->m_Cam0XTextBox->Name = L"m_Cam0XTextBox";
			this->m_Cam0XTextBox->ReadOnly = true;
			this->m_Cam0XTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam0XTextBox->TabIndex = 37;
			// 
			// label13
			// 
			this->label13->AutoSize = true;
			this->label13->Location = System::Drawing::Point(300, 73);
			this->label13->Name = L"label13";
			this->label13->Size = System::Drawing::Size(14, 13);
			this->label13->TabIndex = 36;
			this->label13->Text = L"X";
			// 
			// m_Cam0YTextBox
			// 
			this->m_Cam0YTextBox->Location = System::Drawing::Point(319, 96);
			this->m_Cam0YTextBox->Name = L"m_Cam0YTextBox";
			this->m_Cam0YTextBox->ReadOnly = true;
			this->m_Cam0YTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam0YTextBox->TabIndex = 39;
			// 
			// label14
			// 
			this->label14->AutoSize = true;
			this->label14->Location = System::Drawing::Point(300, 99);
			this->label14->Name = L"label14";
			this->label14->Size = System::Drawing::Size(14, 13);
			this->label14->TabIndex = 38;
			this->label14->Text = L"Y";
			// 
			// m_Cam2YTextBox
			// 
			this->m_Cam2YTextBox->Location = System::Drawing::Point(383, 478);
			this->m_Cam2YTextBox->Name = L"m_Cam2YTextBox";
			this->m_Cam2YTextBox->ReadOnly = true;
			this->m_Cam2YTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam2YTextBox->TabIndex = 43;
			// 
			// label15
			// 
			this->label15->AutoSize = true;
			this->label15->Location = System::Drawing::Point(364, 481);
			this->label15->Name = L"label15";
			this->label15->Size = System::Drawing::Size(14, 13);
			this->label15->TabIndex = 42;
			this->label15->Text = L"Y";
			// 
			// m_Cam2XTextBox
			// 
			this->m_Cam2XTextBox->Location = System::Drawing::Point(383, 452);
			this->m_Cam2XTextBox->Name = L"m_Cam2XTextBox";
			this->m_Cam2XTextBox->ReadOnly = true;
			this->m_Cam2XTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam2XTextBox->TabIndex = 41;
			// 
			// label16
			// 
			this->label16->AutoSize = true;
			this->label16->Location = System::Drawing::Point(364, 455);
			this->label16->Name = L"label16";
			this->label16->Size = System::Drawing::Size(14, 13);
			this->label16->TabIndex = 40;
			this->label16->Text = L"X";
			// 
			// m_Cam3YTextBox
			// 
			this->m_Cam3YTextBox->Location = System::Drawing::Point(959, 482);
			this->m_Cam3YTextBox->Name = L"m_Cam3YTextBox";
			this->m_Cam3YTextBox->ReadOnly = true;
			this->m_Cam3YTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam3YTextBox->TabIndex = 47;
			// 
			// label17
			// 
			this->label17->AutoSize = true;
			this->label17->Location = System::Drawing::Point(940, 485);
			this->label17->Name = L"label17";
			this->label17->Size = System::Drawing::Size(14, 13);
			this->label17->TabIndex = 46;
			this->label17->Text = L"Y";
			// 
			// m_Cam3XTextBox
			// 
			this->m_Cam3XTextBox->Location = System::Drawing::Point(959, 456);
			this->m_Cam3XTextBox->Name = L"m_Cam3XTextBox";
			this->m_Cam3XTextBox->ReadOnly = true;
			this->m_Cam3XTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam3XTextBox->TabIndex = 45;
			// 
			// label18
			// 
			this->label18->AutoSize = true;
			this->label18->Location = System::Drawing::Point(940, 459);
			this->label18->Name = L"label18";
			this->label18->Size = System::Drawing::Size(14, 13);
			this->label18->TabIndex = 44;
			this->label18->Text = L"X";
			// 
			// m_Cam1YTextBox
			// 
			this->m_Cam1YTextBox->Location = System::Drawing::Point(890, 93);
			this->m_Cam1YTextBox->Name = L"m_Cam1YTextBox";
			this->m_Cam1YTextBox->ReadOnly = true;
			this->m_Cam1YTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam1YTextBox->TabIndex = 51;
			// 
			// label19
			// 
			this->label19->AutoSize = true;
			this->label19->Location = System::Drawing::Point(871, 96);
			this->label19->Name = L"label19";
			this->label19->Size = System::Drawing::Size(14, 13);
			this->label19->TabIndex = 50;
			this->label19->Text = L"Y";
			// 
			// m_Cam1XTextBox
			// 
			this->m_Cam1XTextBox->Location = System::Drawing::Point(890, 67);
			this->m_Cam1XTextBox->Name = L"m_Cam1XTextBox";
			this->m_Cam1XTextBox->ReadOnly = true;
			this->m_Cam1XTextBox->Size = System::Drawing::Size(40, 20);
			this->m_Cam1XTextBox->TabIndex = 49;
			// 
			// label20
			// 
			this->label20->AutoSize = true;
			this->label20->Location = System::Drawing::Point(871, 70);
			this->label20->Name = L"label20";
			this->label20->Size = System::Drawing::Size(14, 13);
			this->label20->TabIndex = 48;
			this->label20->Text = L"X";
			// 
			// m_SaveRightShButton
			// 
			this->m_SaveRightShButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_SaveRightShButton->Location = System::Drawing::Point(301, 124);
			this->m_SaveRightShButton->Name = L"m_SaveRightShButton";
			this->m_SaveRightShButton->Size = System::Drawing::Size(75, 23);
			this->m_SaveRightShButton->TabIndex = 52;
			this->m_SaveRightShButton->Text = L"Save";
			this->m_SaveRightShButton->UseVisualStyleBackColor = false;

			// 
			// m_SaveLeftShButton
			// 
			this->m_SaveLeftShButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_SaveLeftShButton->Location = System::Drawing::Point(873, 124);
			this->m_SaveLeftShButton->Name = L"m_SaveLeftShButton";
			this->m_SaveLeftShButton->Size = System::Drawing::Size(75, 23);
			this->m_SaveLeftShButton->TabIndex = 53;
			this->m_SaveLeftShButton->Text = L"Save";
			this->m_SaveLeftShButton->UseVisualStyleBackColor = false;

			// 
			// m_SaveRightVisuButton
			// 
			this->m_SaveRightVisuButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_SaveRightVisuButton->Location = System::Drawing::Point(367, 504);
			this->m_SaveRightVisuButton->Name = L"m_SaveRightVisuButton";
			this->m_SaveRightVisuButton->Size = System::Drawing::Size(75, 23);
			this->m_SaveRightVisuButton->TabIndex = 54;
			this->m_SaveRightVisuButton->Text = L"Save";
			this->m_SaveRightVisuButton->UseVisualStyleBackColor = false;

			// 
			// m_SaveLeftVisuButton
			// 
			this->m_SaveLeftVisuButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_SaveLeftVisuButton->Location = System::Drawing::Point(943, 508);
			this->m_SaveLeftVisuButton->Name = L"m_SaveLeftVisuButton";
			this->m_SaveLeftVisuButton->Size = System::Drawing::Size(75, 23);
			this->m_SaveLeftVisuButton->TabIndex = 55;
			this->m_SaveLeftVisuButton->Text = L"Save";
			this->m_SaveLeftVisuButton->UseVisualStyleBackColor = false;

			// 
			// label21
			// 
			this->label21->AutoSize = true;
			this->label21->Location = System::Drawing::Point(300, 159);
			this->label21->Name = L"label21";
			this->label21->Size = System::Drawing::Size(29, 13);
			this->label21->TabIndex = 56;
			this->label21->Text = L"Gain";
			// 
			// m_RightShGainNumericUpDown
			// 
			this->m_RightShGainNumericUpDown->Location = System::Drawing::Point(335, 157);
			this->m_RightShGainNumericUpDown->Maximum = System::Decimal(gcnew cli::array< System::Int32 >(4) { 999, 0, 0, 0 });
			this->m_RightShGainNumericUpDown->Name = L"m_RightShGainNumericUpDown";
			this->m_RightShGainNumericUpDown->Size = System::Drawing::Size(43, 20);
			this->m_RightShGainNumericUpDown->TabIndex = 57;
			this->m_RightShGainNumericUpDown->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 60, 0, 0, 0 });

			// 
			// m_LeftShGainNumericUpDown
			// 
			this->m_LeftShGainNumericUpDown->Location = System::Drawing::Point(908, 157);
			this->m_LeftShGainNumericUpDown->Maximum = System::Decimal(gcnew cli::array< System::Int32 >(4) { 999, 0, 0, 0 });
			this->m_LeftShGainNumericUpDown->Name = L"m_LeftShGainNumericUpDown";
			this->m_LeftShGainNumericUpDown->Size = System::Drawing::Size(43, 20);
			this->m_LeftShGainNumericUpDown->TabIndex = 59;
			this->m_LeftShGainNumericUpDown->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 60, 0, 0, 0 });

			// 
			// label22
			// 
			this->label22->AutoSize = true;
			this->label22->Location = System::Drawing::Point(873, 159);
			this->label22->Name = L"label22";
			this->label22->Size = System::Drawing::Size(29, 13);
			this->label22->TabIndex = 58;
			this->label22->Text = L"Gain";
			// 
			// m_RightVisuGainNumericUpDown
			// 
			this->m_RightVisuGainNumericUpDown->Location = System::Drawing::Point(399, 537);
			this->m_RightVisuGainNumericUpDown->Maximum = System::Decimal(gcnew cli::array< System::Int32 >(4) { 999, 0, 0, 0 });
			this->m_RightVisuGainNumericUpDown->Name = L"m_RightVisuGainNumericUpDown";
			this->m_RightVisuGainNumericUpDown->Size = System::Drawing::Size(43, 20);
			this->m_RightVisuGainNumericUpDown->TabIndex = 61;
			this->m_RightVisuGainNumericUpDown->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 60, 0, 0, 0 });
	
			// 
			// label23
			// 
			this->label23->AutoSize = true;
			this->label23->Location = System::Drawing::Point(364, 539);
			this->label23->Name = L"label23";
			this->label23->Size = System::Drawing::Size(29, 13);
			this->label23->TabIndex = 60;
			this->label23->Text = L"Gain";
			// 
			// m_LeftVisuGainNumericUpDown
			// 
			this->m_LeftVisuGainNumericUpDown->Location = System::Drawing::Point(975, 542);
			this->m_LeftVisuGainNumericUpDown->Maximum = System::Decimal(gcnew cli::array< System::Int32 >(4) { 999, 0, 0, 0 });
			this->m_LeftVisuGainNumericUpDown->Name = L"m_LeftVisuGainNumericUpDown";
			this->m_LeftVisuGainNumericUpDown->Size = System::Drawing::Size(43, 20);
			this->m_LeftVisuGainNumericUpDown->TabIndex = 63;
			this->m_LeftVisuGainNumericUpDown->Value = System::Decimal(gcnew cli::array< System::Int32 >(4) { 60, 0, 0, 0 });

			// 
			// label24
			// 
			this->label24->AutoSize = true;
			this->label24->Location = System::Drawing::Point(940, 544);
			this->label24->Name = L"label24";
			this->label24->Size = System::Drawing::Size(29, 13);
			this->label24->TabIndex = 62;
			this->label24->Text = L"Gain";
			// 
			// m_ReconectNoResetButton
			// 
			this->m_ReconectNoResetButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_ReconectNoResetButton->Location = System::Drawing::Point(1058, 41);
			this->m_ReconectNoResetButton->Name = L"m_ReconectNoResetButton";
			this->m_ReconectNoResetButton->Size = System::Drawing::Size(116, 23);
			this->m_ReconectNoResetButton->TabIndex = 64;
			this->m_ReconectNoResetButton->Text = L"Reconect No Reset";
			this->m_ReconectNoResetButton->UseVisualStyleBackColor = false;

			// 
			// m_CalibrationButton
			// 
			this->m_CalibrationButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_CalibrationButton->Location = System::Drawing::Point(1099, 192);
			this->m_CalibrationButton->Name = L"m_CalibrationButton";
			this->m_CalibrationButton->Size = System::Drawing::Size(75, 44);
			this->m_CalibrationButton->TabIndex = 65;
			this->m_CalibrationButton->Text = L"Calibration...";

			// 
			// m_buttonPrintTicket
			// 
			this->m_buttonPrintTicket->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_buttonPrintTicket->Location = System::Drawing::Point(1180, 63);
			this->m_buttonPrintTicket->Name = L"m_buttonPrintTicket";
			this->m_buttonPrintTicket->Size = System::Drawing::Size(75, 23);
			this->m_buttonPrintTicket->TabIndex = 66;
			this->m_buttonPrintTicket->Text = L"Ticket";
			this->m_buttonPrintTicket->UseVisualStyleBackColor = false;

			// 
			// SaveLogButton
			// 
			this->SaveLogButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->SaveLogButton->Location = System::Drawing::Point(1104, 658);
			this->SaveLogButton->Name = L"SaveLogButton";
			this->SaveLogButton->Size = System::Drawing::Size(75, 23);
			this->SaveLogButton->TabIndex = 67;
			this->SaveLogButton->Text = L"Save Log";
			this->SaveLogButton->UseVisualStyleBackColor = false;

			// 
			// m_buttonPatientMange
			// 
			this->m_buttonPatientMange->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_buttonPatientMange->Location = System::Drawing::Point(1099, 352);
			this->m_buttonPatientMange->Name = L"m_buttonPatientMange";
			this->m_buttonPatientMange->Size = System::Drawing::Size(75, 42);
			this->m_buttonPatientMange->TabIndex = 68;
			this->m_buttonPatientMange->Text = L"Patients Mangae";
			this->m_buttonPatientMange->UseVisualStyleBackColor = false;

			// 
			// m_ChinRestUpButton
			// 
			this->m_ChinRestUpButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_ChinRestUpButton->Location = System::Drawing::Point(439, 313);
			this->m_ChinRestUpButton->Name = L"m_ChinRestUpButton";
			this->m_ChinRestUpButton->Size = System::Drawing::Size(75, 42);
			this->m_ChinRestUpButton->TabIndex = 69;
			this->m_ChinRestUpButton->Text = L"Chin Rest Up";

			// 
			// m_ChinRestDownButton
			// 
			this->m_ChinRestDownButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_ChinRestDownButton->Location = System::Drawing::Point(439, 361);
			this->m_ChinRestDownButton->Name = L"m_ChinRestDownButton";
			this->m_ChinRestDownButton->Size = System::Drawing::Size(75, 42);
			this->m_ChinRestDownButton->TabIndex = 70;
			this->m_ChinRestDownButton->Text = L"Chin Rest Down";
			this->m_ChinRestDownButton->UseVisualStyleBackColor = false;

			// 
			// ArtificialEyeButton
			// 
			this->ArtificialEyeButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ArtificialEyeButton->Location = System::Drawing::Point(1099, 250);
			this->ArtificialEyeButton->Name = L"ArtificialEyeButton";
			this->ArtificialEyeButton->Size = System::Drawing::Size(75, 42);
			this->ArtificialEyeButton->TabIndex = 71;
			this->ArtificialEyeButton->Text = L"Artificial Eye...";
			this->ArtificialEyeButton->UseVisualStyleBackColor = false;

			// 
			// m_CalibrationBackupButton
			// 
			this->m_CalibrationBackupButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_CalibrationBackupButton->Location = System::Drawing::Point(1099, 407);
			this->m_CalibrationBackupButton->Name = L"m_CalibrationBackupButton";
			this->m_CalibrationBackupButton->Size = System::Drawing::Size(75, 61);
			this->m_CalibrationBackupButton->TabIndex = 72;
			this->m_CalibrationBackupButton->Text = L"Calibration Backup";
			this->m_CalibrationBackupButton->UseVisualStyleBackColor = false;

			// 
			// m_RestoreCalibrationBackupButton
			// 
			this->m_RestoreCalibrationBackupButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->m_RestoreCalibrationBackupButton->Location = System::Drawing::Point(1099, 472);
			this->m_RestoreCalibrationBackupButton->Name = L"m_RestoreCalibrationBackupButton";
			this->m_RestoreCalibrationBackupButton->Size = System::Drawing::Size(75, 61);
			this->m_RestoreCalibrationBackupButton->TabIndex = 73;
			this->m_RestoreCalibrationBackupButton->Text = L"Restore Calibration Backup";
			this->m_RestoreCalibrationBackupButton->UseVisualStyleBackColor = false;

			// 
			// AtpButton
			// 
			this->AtpButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->AtpButton->Location = System::Drawing::Point(1180, 192);
			this->AtpButton->Name = L"AtpButton";
			this->AtpButton->Size = System::Drawing::Size(75, 44);
			this->AtpButton->TabIndex = 74;
			this->AtpButton->Text = L"ATP...";
			this->AtpButton->UseVisualStyleBackColor = false;

			// 
			// NewMacAddressButton
			// 
			this->NewMacAddressButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->NewMacAddressButton->Location = System::Drawing::Point(1200, 300);
			this->NewMacAddressButton->Name = L"NewMacAddressButton";
			this->NewMacAddressButton->Size = System::Drawing::Size(95, 44);
			this->NewMacAddressButton->TabIndex = 82;
			this->NewMacAddressButton->Text = L"NewMac";
			this->NewMacAddressButton->UseVisualStyleBackColor = false;

			// 
			// FirstEncryptionButton
			// 
			this->FirstEncryptionButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->FirstEncryptionButton->Location = System::Drawing::Point(1100, 300);
			this->FirstEncryptionButton->Name = L"FirstEncryptionButton";
			this->FirstEncryptionButton->Size = System::Drawing::Size(95, 44);
			this->FirstEncryptionButton->TabIndex = 83;
			this->FirstEncryptionButton->Text = L"First\nEncryption";
			this->FirstEncryptionButton->UseVisualStyleBackColor = false;

			// 
			// ShutDownButton
			// 
			this->ShutDownButton->BackColor = System::Drawing::SystemColors::ControlDark;
			this->ShutDownButton->Location = System::Drawing::Point(1184, 10);
			this->ShutDownButton->Name = L"ShutDownButton";
			this->ShutDownButton->Size = System::Drawing::Size(95, 44);
			this->ShutDownButton->TabIndex = 85;
			this->ShutDownButton->Text = L"ShutDown";
			this->ShutDownButton->UseVisualStyleBackColor = false;

			// 
			// UpgradeSoftwareButton
			// 
			this->UpgradeSoftwareButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->UpgradeSoftwareButton->Location = System::Drawing::Point(1180, 124);
			this->UpgradeSoftwareButton->Name = L"UpgradeSoftwareButton";
			this->UpgradeSoftwareButton->Size = System::Drawing::Size(112, 48);
			this->UpgradeSoftwareButton->TabIndex = 75;
			this->UpgradeSoftwareButton->Text = L"Upgrade Software";
			this->UpgradeSoftwareButton->UseVisualStyleBackColor = false;

			// 
			// TestsThreadCheckBox
			// 
			this->TestsThreadCheckBox->AutoSize = true;
			this->TestsThreadCheckBox->BackColor = System::Drawing::SystemColors::Control;
			this->TestsThreadCheckBox->Location = System::Drawing::Point(1190, 250);
			this->TestsThreadCheckBox->Name = L"TestsThreadCheckBox";
			this->TestsThreadCheckBox->Size = System::Drawing::Size(89, 17);
			this->TestsThreadCheckBox->TabIndex = 76;
			this->TestsThreadCheckBox->Text = L"Tests Thread";
			this->TestsThreadCheckBox->UseVisualStyleBackColor = false;

			// 
			// label25
			// 
			this->label25->AutoSize = true;
			this->label25->Location = System::Drawing::Point(367, 590);
			this->label25->Name = L"label25";
			this->label25->Size = System::Drawing::Size(46, 13);
			this->label25->TabIndex = 77;
			this->label25->Text = L"Contrast";
			// 
			// label26
			// 
			this->label26->AutoSize = true;
			this->label26->Location = System::Drawing::Point(940, 587);
			this->label26->Name = L"label26";
			this->label26->Size = System::Drawing::Size(46, 13);
			this->label26->TabIndex = 78;
			this->label26->Text = L"Contrast";
			// 
			// RightContrastTextBox
			// 
			this->RightContrastTextBox->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 24, System::Drawing::FontStyle::Regular,
				System::Drawing::GraphicsUnit::Point, static_cast<System::Byte>(0)));
			this->RightContrastTextBox->Location = System::Drawing::Point(416, 573);
			this->RightContrastTextBox->Name = L"RightContrastTextBox";
			this->RightContrastTextBox->ReadOnly = true;
			this->RightContrastTextBox->Size = System::Drawing::Size(146, 44);
			this->RightContrastTextBox->TabIndex = 79;
			// 
			// LeftContrastTextBox
			// 
			this->LeftContrastTextBox->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 24, System::Drawing::FontStyle::Regular,
				System::Drawing::GraphicsUnit::Point, static_cast<System::Byte>(0)));
			this->LeftContrastTextBox->Location = System::Drawing::Point(990, 573);
			this->LeftContrastTextBox->Name = L"LeftContrastTextBox";
			this->LeftContrastTextBox->ReadOnly = true;
			this->LeftContrastTextBox->Size = System::Drawing::Size(146, 44);
			this->LeftContrastTextBox->TabIndex = 80;
			// 
			// ShowContrastCheckBox
			// 
			this->ShowContrastCheckBox->AutoSize = true;
			this->ShowContrastCheckBox->BackColor = System::Drawing::SystemColors::Control;
			this->ShowContrastCheckBox->Location = System::Drawing::Point(1190, 275);
			this->ShowContrastCheckBox->Name = L"ShowContrastCheckBox";
			this->ShowContrastCheckBox->Size = System::Drawing::Size(95, 17);
			this->ShowContrastCheckBox->TabIndex = 81;
			this->ShowContrastCheckBox->Text = L"Show Contrast";
			this->ShowContrastCheckBox->UseVisualStyleBackColor = false;
			// 
			// SendToTabletButton
			// 
			this->SendToTabletButton->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->SendToTabletButton->Location = System::Drawing::Point(1200, 350);
			this->SendToTabletButton->Name = L"SendToTabletButton";
			this->SendToTabletButton->Size = System::Drawing::Size(95, 44);
			this->SendToTabletButton->TabIndex = 84;
			this->SendToTabletButton->Text = L"SendToTablet...";
			this->SendToTabletButton->UseVisualStyleBackColor = false;
			// 
			// Form1
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->AutoScroll = true;
			this->ClientSize = System::Drawing::Size(1348, 877);
			this->Controls->Add(this->SendToTabletButton);
			this->Controls->Add(this->ShowContrastCheckBox);
			this->Controls->Add(this->LeftContrastTextBox);
			this->Controls->Add(this->RightContrastTextBox);
			this->Controls->Add(this->label26);
			this->Controls->Add(this->label25);
			this->Controls->Add(this->TestsThreadCheckBox);
			this->Controls->Add(this->UpgradeSoftwareButton);
			this->Controls->Add(this->AtpButton);
			this->Controls->Add(this->NewMacAddressButton);
			this->Controls->Add(this->FirstEncryptionButton);
			this->Controls->Add(this->ShutDownButton);
			this->Controls->Add(this->m_RestoreCalibrationBackupButton);
			this->Controls->Add(this->m_CalibrationBackupButton);
			this->Controls->Add(this->ArtificialEyeButton);
			this->Controls->Add(this->m_ChinRestDownButton);
			this->Controls->Add(this->m_ChinRestUpButton);
			this->Controls->Add(this->m_buttonPatientMange);
			this->Controls->Add(this->SaveLogButton);
			this->Controls->Add(this->m_buttonPrintTicket);
			this->Controls->Add(this->m_CalibrationButton);
			this->Controls->Add(this->m_ReconectNoResetButton);
			this->Controls->Add(this->m_LeftVisuGainNumericUpDown);
			this->Controls->Add(this->label24);
			this->Controls->Add(this->m_RightVisuGainNumericUpDown);
			this->Controls->Add(this->label23);
			this->Controls->Add(this->m_LeftShGainNumericUpDown);
			this->Controls->Add(this->label22);
			this->Controls->Add(this->m_RightShGainNumericUpDown);
			this->Controls->Add(this->label21);
			this->Controls->Add(this->m_SaveLeftVisuButton);
			this->Controls->Add(this->m_SaveRightVisuButton);
			this->Controls->Add(this->m_SaveLeftShButton);
			this->Controls->Add(this->m_SaveRightShButton);
			this->Controls->Add(this->m_Cam1YTextBox);
			this->Controls->Add(this->label19);
			this->Controls->Add(this->m_Cam1XTextBox);
			this->Controls->Add(this->label20);
			this->Controls->Add(this->m_Cam3YTextBox);
			this->Controls->Add(this->label17);
			this->Controls->Add(this->m_Cam3XTextBox);
			this->Controls->Add(this->label18);
			this->Controls->Add(this->m_Cam2YTextBox);
			this->Controls->Add(this->label15);
			this->Controls->Add(this->m_Cam2XTextBox);
			this->Controls->Add(this->label16);
			this->Controls->Add(this->m_Cam0YTextBox);
			this->Controls->Add(this->label14);
			this->Controls->Add(this->m_Cam0XTextBox);
			this->Controls->Add(this->label13);
			this->Controls->Add(this->m_ImageButton);
			this->Controls->Add(this->m_MeasureButton);
			this->Controls->Add(this->m_ControllerButton);
			this->Controls->Add(this->m_CheckLimitsThreadCheckBox);
			this->Controls->Add(this->m_TestButton);
			this->Controls->Add(this->Clients3TextBox);
			this->Controls->Add(this->Clients2TextBox);
			this->Controls->Add(this->Clients0TextBox);
			this->Controls->Add(this->Clients1TextBox);
			this->Controls->Add(this->label12);
			this->Controls->Add(this->label11);
			this->Controls->Add(this->label10);
			this->Controls->Add(this->label9);
			this->Controls->Add(this->ClearButton);
			this->Controls->Add(this->m_ReconnectButton);
			this->Controls->Add(this->m_StatusListBox);
			this->Controls->Add(this->m_FpsCam3TextBox);
			this->Controls->Add(this->label8);
			this->Controls->Add(this->m_FpsCam2TextBox);
			this->Controls->Add(this->label7);
			this->Controls->Add(this->m_FpsCam1TextBox);
			this->Controls->Add(this->label6);
			this->Controls->Add(this->m_FpsCam0TextBox);
			this->Controls->Add(this->label5);
			this->Controls->Add(this->m_Cam3IdTextBox);
			this->Controls->Add(this->m_Cam2IdTextBox);
			this->Controls->Add(this->m_Cam1IdTextBox);
			this->Controls->Add(this->m_Cam0IdTextBox);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->m_Cam3PictureBox);
			this->Controls->Add(this->m_Cam2PictureBox);
			this->Controls->Add(this->m_Cam1PictureBox);
			this->Controls->Add(this->m_Cam0PictureBox);
			this->Name = L"Form1";
			this->Text = L"Eye Refract";
			this->WindowState = System::Windows::Forms::FormWindowState::Minimized;

			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam0PictureBox))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam1PictureBox))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam3PictureBox))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_Cam2PictureBox))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_RightShGainNumericUpDown))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_LeftShGainNumericUpDown))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_RightVisuGainNumericUpDown))->EndInit();
			(cli::safe_cast<System::ComponentModel::ISupportInitialize^>(this->m_LeftVisuGainNumericUpDown))->EndInit();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	
	private: System::Void ClearButton_Click(System::Object^  sender, System::EventArgs^  e)
	{
		this->m_StatusListBox->Items->Clear();
	}
	public: delegate void DelegateForFormClosing(System::Object^  sender, System::Windows::Forms::FormClosingEventArgs^  e);

	public: System::Void Form1_FormClosing(System::Object^  sender, System::Windows::Forms::FormClosingEventArgs^  e) {

		if (this->InvokeRequired)
		{
			DelegateForFormClosing ^d = gcnew DelegateForFormClosing(this, &Form1::Form1_FormClosing);
			this->Invoke(d, sender, e);
		}
		else
		{
		}
	}


	private: delegate void DelegateForSendToTabletServer(System::String^ Msg);
	public: void SendToTabletServer(System::String^ Msg)
	{
		
	}

	
	private: System::Void m_TestButton_Click(System::Object^  sender, System::EventArgs^  e){}

	private: System::Void m_CheckLimitsThreadCheckBox_CheckedChanged(System::Object^  sender, System::EventArgs^  e){}

	private: System::Void m_ControllerButton_Click(System::Object^  sender, System::EventArgs^  e)
	{
	
	}


	private: System::Void m_Cam1PictureBox_MouseClick(System::Object^  sender, System::Windows::Forms::MouseEventArgs^  e) 
	{
		
	}


	private: System::Void m_Cam0PictureBox_MouseClick(System::Object^  sender, System::Windows::Forms::MouseEventArgs^  e) 
	{
		
	}


	private: System::Void m_Cam2PictureBox_MouseClick(System::Object^  sender, System::Windows::Forms::MouseEventArgs^  e) 
	{
		
	}


	private: System::Void m_Cam3PictureBox_MouseClick(System::Object^  sender, System::Windows::Forms::MouseEventArgs^  e) 
	{
		
	}

	private: System::Void m_MeasureButton_Click(System::Object^  sender, System::EventArgs^  e) 
	{
	}

	public: System::Void StopMeasure() 
	{

	} 

	private: System::Void m_ImageButton_Click(System::Object^  sender, System::EventArgs^  e) 
	{

	}

	private: System::Void m_SaveRightShButton_Click(System::Object^  sender, System::EventArgs^  e)
	{
		
	}

	private: System::Void m_SaveLeftShButton_Click(System::Object^  sender, System::EventArgs^  e) 
	{
		
	}

	private: System::Void m_SaveRightVisuButton_Click(System::Object^  sender, System::EventArgs^  e) 
	{
		
	}


	private: System::Void m_SaveLeftVisuButton_Click(System::Object^  sender, System::EventArgs^  e) 
	{
		
	}

	private: System::Void m_RightShGainNumericUpDown_ValueChanged(System::Object^  sender, System::EventArgs^  e) 
	{

	}

	private: System::Void m_LeftShGainNumericUpDown_ValueChanged(System::Object^  sender, System::EventArgs^  e) 
	{
		
	}


	private: System::Void m_LeftVisuGainNumericUpDown_ValueChanged(System::Object^  sender, System::EventArgs^  e) 
	{
		
	}

	private: System::Void m_RightVisuGainNumericUpDown_ValueChanged(System::Object^  sender, System::EventArgs^  e) 
	{
		
	}


	

	private: double m_StepSphere;
	

	public: property bool MeasureStationTable;
	private: System::Void Form1_Load(System::Object^  sender, System::EventArgs^  e) {
	}
	private: System::Void SendToTabletButton_Click(System::Object^  sender, System::EventArgs^  e) {
	
	}
public: System::Void UpdateForm();
};

}

