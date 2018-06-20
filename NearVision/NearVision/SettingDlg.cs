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
        private ConfigMgr _config;

        public SettingDlg(ConfigMgr config)
        {
            InitializeComponent();

            _config = config;
            langBox.Items.AddRange(config.GetLangNames().ToArray());
            langBox.SelectedItem = config.CurrentLangName;

            this.langBox.SelectedIndexChanged +=
            new System.EventHandler(langBox_SelectedIndexChanged);
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

            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
