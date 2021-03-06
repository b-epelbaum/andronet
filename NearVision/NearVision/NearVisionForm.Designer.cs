﻿namespace NearVision
{
    partial class NearVisionForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(NearVisionForm));
            this._browserBox = new System.Windows.Forms.WebBrowser();
            this._textHeader = new System.Windows.Forms.Label();
            this._textBox = new System.Windows.Forms.Label();
            this._imageBox = new System.Windows.Forms.PictureBox();
            this.ControlPanel = new NearVision.ExtendedPanel();
            this._logButton = new System.Windows.Forms.Button();
            this.ZoomButton = new System.Windows.Forms.Button();
            this.SettingButton = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this._imageBox)).BeginInit();
            this.ControlPanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // _browserBox
            // 
            this._browserBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this._browserBox.Location = new System.Drawing.Point(0, 0);
            this._browserBox.MinimumSize = new System.Drawing.Size(20, 20);
            this._browserBox.Name = "_browserBox";
            this._browserBox.Size = new System.Drawing.Size(989, 744);
            this._browserBox.TabIndex = 0;
            // 
            // _textHeader
            // 
            this._textHeader.Anchor = System.Windows.Forms.AnchorStyles.None;
            this._textHeader.BackColor = System.Drawing.Color.Transparent;
            this._textHeader.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this._textHeader.Location = new System.Drawing.Point(-12, 58);
            this._textHeader.Name = "_textHeader";
            this._textHeader.Size = new System.Drawing.Size(989, 24);
            this._textHeader.TabIndex = 2;
            this._textHeader.Text = "N36";
            this._textHeader.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this._textHeader.Visible = false;
            // 
            // _textBox
            // 
            this._textBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this._textBox.BackColor = System.Drawing.Color.Transparent;
            this._textBox.Location = new System.Drawing.Point(0, -9);
            this._textBox.Name = "_textBox";
            this._textBox.Size = new System.Drawing.Size(989, 744);
            this._textBox.TabIndex = 2;
            this._textBox.Text = "In a beautiful \r\nmeadow neart\r\nhe lake";
            this._textBox.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this._textBox.Visible = false;
            // 
            // _imageBox
            // 
            this._imageBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this._imageBox.Location = new System.Drawing.Point(0, 0);
            this._imageBox.Name = "_imageBox";
            this._imageBox.Size = new System.Drawing.Size(989, 744);
            this._imageBox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
            this._imageBox.TabIndex = 1;
            this._imageBox.TabStop = false;
            this._imageBox.Visible = false;
            // 
            // ControlPanel
            // 
            this.ControlPanel.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.ControlPanel.BackColor = System.Drawing.Color.Transparent;
            this.ControlPanel.Controls.Add(this._logButton);
            this.ControlPanel.Controls.Add(this.ZoomButton);
            this.ControlPanel.Controls.Add(this.SettingButton);
            this.ControlPanel.Location = new System.Drawing.Point(189, 475);
            this.ControlPanel.Name = "ControlPanel";
            this.ControlPanel.Opacity = 0;
            this.ControlPanel.Size = new System.Drawing.Size(614, 122);
            this.ControlPanel.TabIndex = 4;
            // 
            // _logButton
            // 
            this._logButton.FlatAppearance.BorderSize = 0;
            this._logButton.Image = global::NearVision.Properties.Resources.log;
            this._logButton.Location = new System.Drawing.Point(259, 14);
            this._logButton.Name = "_logButton";
            this._logButton.Size = new System.Drawing.Size(96, 96);
            this._logButton.TabIndex = 3;
            this._logButton.UseVisualStyleBackColor = true;
            this._logButton.Click += new System.EventHandler(this.LogButton_Click);
            // 
            // ZoomButton
            // 
            this.ZoomButton.FlatAppearance.BorderSize = 0;
            this.ZoomButton.Image = ((System.Drawing.Image)(resources.GetObject("ZoomButton.Image")));
            this.ZoomButton.Location = new System.Drawing.Point(62, 14);
            this.ZoomButton.Name = "ZoomButton";
            this.ZoomButton.Size = new System.Drawing.Size(96, 96);
            this.ZoomButton.TabIndex = 3;
            this.ZoomButton.UseVisualStyleBackColor = true;
            this.ZoomButton.Click += new System.EventHandler(this.ZoomButton_Click);
            // 
            // SettingButton
            // 
            this.SettingButton.Image = global::NearVision.Properties.Resources.settings_icon_14976;
            this.SettingButton.Location = new System.Drawing.Point(457, 14);
            this.SettingButton.Name = "SettingButton";
            this.SettingButton.Size = new System.Drawing.Size(96, 96);
            this.SettingButton.TabIndex = 3;
            this.SettingButton.UseVisualStyleBackColor = true;
            this.SettingButton.Click += new System.EventHandler(this.SettingButton_Click);
            // 
            // NearVisionForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(989, 744);
            this.Controls.Add(this.ControlPanel);
            this.Controls.Add(this._textBox);
            this.Controls.Add(this._textHeader);
            this.Controls.Add(this._imageBox);
            this.Controls.Add(this._browserBox);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "NearVisionForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "NearVision Client";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.NearVisionForm_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this._imageBox)).EndInit();
            this.ControlPanel.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.WebBrowser _browserBox;
        private System.Windows.Forms.PictureBox _imageBox;
        private System.Windows.Forms.Label _textHeader;
        private System.Windows.Forms.Label _textBox;
        private System.Windows.Forms.Button ZoomButton;
        private System.Windows.Forms.Button SettingButton;
        private ExtendedPanel ControlPanel;
        private System.Windows.Forms.Button _logButton;
    }
}

