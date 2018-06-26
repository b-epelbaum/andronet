﻿using Newtonsoft.Json;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Windows.Forms;

namespace NearVision
{

    public class General
    {
        public string ServerIP { get; set; }
        public int Port { get; set; }
        public bool IsSSL { get; set; }
    }

    public class Command
    {
        public int ID { get; set; }
        public string Cmd { get; set; }
        public string Type { get; set; }
        public string Name { get; set; }
        public string Media { get; set; }
    }


    public class BlockArray
    {
        public double FontSize { get; set; }
        public string ArrayUnit { get; set; }
        public string Paragraph { get; set; }
    }

    public class TextTestData
    {
        public string LangId { get; set; }
        public string LangName { get; set; }
        public List<BlockArray> BlockArray { get; set; }
    }

    public class RootObject
    {
        public General General { get; set; }
        public List<string> CmdType { get; set; }
        public List<Command> Commands { get; set; }
        public List<TextTestData> TextTestData { get; set; }
    }

    public class ConfigMgr
    {
        public delegate void LanguageChanged( string langId );

        //declare event of type delegate
        public event LanguageChanged LanguageChangedEvent;

        public ConfigMgr(RootObject rootObj)
        {
            RootObject = rootObj;
            General = RootObject.General;
        }

        public static ConfigMgr Init()
        {
            var appPath = Application.StartupPath;
            var retVal =  new ConfigMgr(JsonConvert.DeserializeObject<RootObject>(File.ReadAllText(Application.StartupPath+"/NearVision.json")));
            retVal.InitLangIDs();
            retVal.InitCommandMap();

            retVal._brightness = Properties.Settings.Default.BrightnessCoeff;
            return retVal;
        }

        public General General { get; }

        public List<string> GetLangIDs ()
        {
            return RootObject.TextTestData.Select(l => l.LangId).ToList();
        }

        public List<string> GetLangNames()
        {
            return RootObject.TextTestData.Select(l => l.LangName).ToList();
        }

        public List<BlockArray> GetBlocks ( string langId )
        {
            return RootObject.TextTestData.Where(l => l.LangId == langId).Select(g => g.BlockArray).SingleOrDefault();
        }

       private RootObject RootObject { get; set; }

        public string CurrentLangId {
            get => _currentLangId;
            set  {
                _currentLangId = value;
                Properties.Settings.Default.LanguageID = _currentLangId;
                Properties.Settings.Default.Save();
                LanguageChangedEvent?.Invoke(_currentLangId);
            }
        }

        public int Brightness
        {
            get => _brightness;
            set
            {
                _brightness = value;
                Properties.Settings.Default.BrightnessCoeff = _brightness;
                Properties.Settings.Default.Save();
            }
        }

        public string CurrentLangName
        {
            get => _currentLangName;
            set
            {
                _currentLangName = value;
                CurrentLangId = RootObject.TextTestData.Where(l => l.LangName == value).Select(g => g.LangId).Single();
            }
        }

        public Command GetCommandById(int CmdId)
        {
            return _commandIdMap[CmdId];
        }

        public Command GetCommandByName(string CmdName)
        {
            return _commandNameMap[CmdName];
        }

        private void InitLangIDs ()
        {
            _currentLangId = Properties.Settings.Default.LanguageID;
            _currentLangName = RootObject.TextTestData.Where(l => l.LangId == CurrentLangId).Select(g => g.LangName).Single();
        }

        private void InitCommandMap()
        {
            _commandIdMap = RootObject.Commands.ToDictionary(x => x.ID);
            _commandNameMap = RootObject.Commands.ToDictionary(x => x.Cmd);
        }

       

        private int _brightness;
        private string _currentLangId;
        private string _currentLangName;
        private Dictionary<int, Command> _commandIdMap;
        private Dictionary<string, Command> _commandNameMap;
    }
}
