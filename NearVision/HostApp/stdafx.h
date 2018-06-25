// stdafx.h : include file for standard system include files,
// or project specific include files that are used frequently, but
// are changed infrequently
#pragma once

// TODO: reference additional headers your program requires here
#define _AFXDLL

#define _CRT_SECURE_NO_DEPRECATE 

#ifndef VC_EXTRALEAN
#define VC_EXTRALEAN		// Exclude rarely-used stuff from Windows headers
#endif

// Modify the following defines if you have to target a platform prior to the ones specified below.
// Refer to MSDN for the latest info on corresponding values for different platforms.
#ifndef NTDDI_VERSION						// Allow use of features specific to Windows 2000 and XP or later.
#define NTDDI_VERSION 0x06010000	//NTDDI_WINXPSP3		// 0x05010300 - for W7 NTDDI_WIN7 0x06010000
#endif

#ifndef WINVER					// Allow use of features specific to Windows 2000 and XP or later.
#define WINVER 0x601	//0x0502			// Change this to the appropriate value to target Windows XP with SP2  or later.
#endif

#ifndef _WIN32_WINNT						// Allow use of features specific to Windows NT 4 or later.
#define _WIN32_WINNT 0x601	//0x501		// Change this to the appropriate value to target Windows XP with SP2 or later.
#endif						

#ifndef _WIN32_WINDOWS		// Allow use of features specific to Windows 98 or later.
#define _WIN32_WINDOWS 0x601	//0x0502 // Change this to the appropriate value to target Windows XP with SP2 or later.
#endif

#ifndef _WIN32_IE			// Allow use of features specific to IE 4.0 or later.
#define _WIN32_IE 0x0600	// Change this to the appropriate value to target IE 6.0 or later.
#endif

#define _ATL_CSTRING_EXPLICIT_CONSTRUCTORS	// some CString constructors will be explicit

// turns off MFC's hiding of some common and often safely ignored warning messages
#define _AFX_ALL_WARNINGS

#include <afxwin.h>         // MFC core and standard components
#include <afxext.h>         // MFC extensions
#include <afxdisp.h>        // MFC Automation classes

#include <afxdtctl.h>		// MFC support for Internet Explorer 4 Common Controls
#ifndef _AFX_NO_AFXCMN_SUPPORT
#include <afxcmn.h>			// MFC support for Windows Common Controls
#endif // _AFX_NO_AFXCMN_SUPPORT
#include <afxdhtml.h>
#include <afxdlgs.h>
#include <afxhtml.h>
#include <afxcontrolbars.h>





//#pragma warning( disable : 4702  )


