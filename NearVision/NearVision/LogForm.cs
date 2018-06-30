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
    public partial class LogForm : Form
    {
        public delegate void LogBoxInited();
        //declare event of type delegate
        public event LogBoxInited LogBoxInitedEvent;

        private static readonly log4net.ILog _log = log4net.LogManager.GetLogger(typeof(LogForm));
        public LogForm()
        {
            InitializeComponent();
        }

        public TextBox GetTextBox() { return _logBox;  }

        private void LogForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            e.Cancel = true;
            Hide();
        }

        private void LogForm_Load(object sender, EventArgs e)
        {
            TextBoxAppender.ConfigureTextBoxAppender(_logBox);
            LogBoxInitedEvent?.Invoke();
        }
    }
}
