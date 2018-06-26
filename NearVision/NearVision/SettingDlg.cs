using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NearVision
{
    public partial class SettingDlg : Form
    {
        public delegate void BrightnessChanged(int value);
        public event BrightnessChanged BrightnessChangedEvent;

        private ConfigMgr _config;

        public SettingDlg(ConfigMgr config)
        {
            InitializeComponent();

            _config = config;

            trackBar1.DataBindings.Add(new Binding("Value", numericUpDown1, "Value"));
            numericUpDown1.DataBindings.Add(new Binding("Value", trackBar1, "Value"));

            trackBar1.Value = _config.Brightness;
            langBox.Items.AddRange(config.GetLangNames().ToArray());
            langBox.SelectedItem = config.CurrentLangName;
        }

        private void langBox_SelectedIndexChanged(object sender, EventArgs e)
        {
        }

        private void CancelButton_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            this.Close();
        }

        private void OkButton_Click(object sender, EventArgs e)
        {
            _config.CurrentLangName = (string)langBox.SelectedItem;
            _config.Brightness = trackBar1.Value;

            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            BrightnessChangedEvent?.Invoke(((TrackBar)sender).Value);
        }
    }
}
