{\rtf1\ansi\ansicpg1252\cocoartf1504\cocoasubrtf820
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid1\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid1}
{\list\listtemplateid2\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid101\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid2}
{\list\listtemplateid3\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid201\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid3}
{\list\listtemplateid4\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid301\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid4}
{\list\listtemplateid5\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid401\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid5}
{\list\listtemplateid6\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid501\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid6}
{\list\listtemplateid7\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid601\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid7}
{\list\listtemplateid8\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid701\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid8}
{\list\listtemplateid9\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid801\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid9}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}{\listoverride\listid2\listoverridecount0\ls2}{\listoverride\listid3\listoverridecount0\ls3}{\listoverride\listid4\listoverridecount0\ls4}{\listoverride\listid5\listoverridecount0\ls5}{\listoverride\listid6\listoverridecount0\ls6}{\listoverride\listid7\listoverridecount0\ls7}{\listoverride\listid8\listoverridecount0\ls8}{\listoverride\listid9\listoverridecount0\ls9}}
\margl1440\margr1440\vieww28600\viewh15340\viewkind0
\deftab720
\pard\pardeftab720\ri0\partightenfactor0

\f0\b\fs36 \cf0 HTML Code Generator Application
\b0\fs24 \
============================\
\
This application aims to help web-designers or web owners who do not have any coding background to create a simple web page. Its main function is generating HTML and some CSS coding and build the entire HTML code for the web page. It works based on the user\'92s requirements by clicking the available buttons in the code generator feature. \
\
============================\
\

\b\fs28 Java Libraries used in this application are:
\fs24 \
\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri0\partightenfactor0
\ls1\ilvl0
\b0 \cf0 {\listtext	\'95	}Apache POI HSSF\ul \
\ls1\ilvl0\ulnone {\listtext	\'95	}Desktop\
{\listtext	\'95	}
\fs22 BufferedWriter\
\pard\tx720\pardeftab720\ri0\partightenfactor0

\fs24 \cf0 \
============================\
\
\pard\tx720\pardeftab720\ri0\partightenfactor0

\b\fs28 \cf0 Excel Files used in this App:\
\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri0\partightenfactor0
\ls2\ilvl0
\b0\fs24 \cf0 {\listtext	\'95	}fonts\
{\listtext	\'95	}HTML tags\
\pard\tx720\pardeftab720\ri0\partightenfactor0
\cf0 \
============================\
\
\pard\tx720\pardeftab720\ri0\partightenfactor0

\b\fs28 \cf0 Application Main Window:
\b0\fs24 \
\

\b NavigationView:
\b0  this class is responsible for building the interface of the main window of the application. It includes three options as buttons, which are:\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri0\partightenfactor0
\ls3\ilvl0\cf0 {\listtext	\'95	}HTML Code Generator\
{\listtext	\'95	}HTML Sources\
{\listtext	\'95	}Open File\
\pard\tx720\pardeftab720\ri0\partightenfactor0
\cf0 It also listens to the users\'92 actions and direct users to the clicked option\'92s window.\
\
============================\
\
\
\
\pard\pardeftab720\ri0\partightenfactor0

\b\fs28 \cf0 HTML Code Generator feature:
\b0\fs24 \
The Code Generator option has many features in it. It helps users to design their text through generating html codes to manipulate that text. It also allows users to insert images, videos and change the background\'92s color or image. The generator feature was built based on three Java classes, which are:\
\pard\pardeftab720\li720\fi-360\ri0\partightenfactor0
\ls4\ilvl0\cf0 \'95	generatorModel\
\'95	generatorView\
\'95	generatorCntrl\
\pard\pardeftab720\li360\ri0\partightenfactor0
\cf0 \
\
\pard\pardeftab720\ri0\partightenfactor0
\cf0 The \'93generatorModel\'94, includes the connection between the application and the two Excel spreadsheets. Those two Excel sheets have the types of fonts and the HTML tags stored in them. The App reads those sheets and retrieve the appropriate data and use them in the generatorCntrl. It uses the \ul Apache POI HSSF\ulnone  library to enable the code to connect with the Excel sheet.\
\
The \'93generatorCntrl\'94 has method that are responsible for generating HTML and CSS codes and inserting the generated code to the full HTML code of the web page. It uses both generatorModel and generatorView.\
\
\

\b\fs28 HTML Sources feature:
\b0\fs24 \
There are two Java classes are responsible for providing HTML Sources to the user. Those classes are:\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri0\partightenfactor0
\ls5\ilvl0\cf0 {\listtext	\'95	}sourcesView\
{\listtext	\'95	}sourcesCntrl\
\pard\tx720\pardeftab720\ri0\partightenfactor0
\cf0 \
SourcesView is responsible for creating the interface. And the sourcesCntrl  has only one method that can be used in the SourcesView to open links using the user\'92s default browser. The sourcesCntrl uses the Desktop library to execute actions using the user\'92s desktop.\
\
\
\pard\tx720\pardeftab720\ri0\partightenfactor0

\b\fs28 \cf0 Save File feature:
\b0\fs24 \
The open and save feature has two classes, which are:\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri0\partightenfactor0
\ls6\ilvl0\cf0 {\listtext	\'95	}fileSaverCntrl\
{\listtext	\'95	}fileSaverView\
\pard\tx720\pardeftab720\ri0\partightenfactor0
\cf0 \
The saveFileView uses the JFileChooser to enable the application to view the user directories. It also has two methods, one method is responsible for displaying the directories for saving the full HTML code that the user created and execute the save command using the saveFileCntrl class. The second method does exactly the same function but it has one more command which is viewing the HTML page using the saveFileCntrl class.\
\
The 
\i saveFileCntrl
\i0   also has two method which execute commands to save the file or view the file. The libraries used to execute actions in the 
\i saveFileCntrl
\i0  are:\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri0\partightenfactor0
\ls7\ilvl0
\fs22 \cf0 {\listtext	\'95	}saveFile method, uses the \'93
\i BufferedWriter
\i0 \'94 library to write the on the full HTML code on the file created by the application.\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri116\partightenfactor0
\ls8\ilvl0
\fs24 \cf0 {\listtext	\'95	}viewFile method, uses the \'93
\i Desktop
\i0 \'94 library to open the \'93html\'94 file created by the application using the user\'92s default browser.\
\pard\tx720\pardeftab720\ri116\partightenfactor0
\cf0 \
\

\b\fs28 File Opener feature:
\b0\fs24 \
\pard\tx720\pardeftab720\ri0\partightenfactor0
\cf0 This feature is responsible for retrieving the saved HTML file and import it to the application to allow users to add more content to it. The classes used to build this feature were:\
\pard\tx220\tx720\pardeftab720\li720\fi-720\ri0\partightenfactor0
\ls9\ilvl0\cf0 {\listtext	\'95	}fileOpenerView\
{\listtext	\'95	}fileOpenercntrl\
\pard\tx720\pardeftab720\ri0\partightenfactor0
\cf0 \
The 
\i fileOpenerView
\i0  class is reposnsible for displaying the user\'92s directories using the import mode using the 
\i JFileChooser
\i0  frame. The import mode allows the user to execute a command to open the file using the 
\i fileOpenercntrl. 
\i0 It is similar the the fileSaverclass but the saver allows the user to view the directories using the export mode, which enables the user to only save the file to the desktop.\
\
The 
\i fileOpenerCntrl
\i0  class controls the file by opening it and stores the lines of the code in an ArrayList. After storing all lines in the ArrayList\'92s elements it sets the text area of the full HTML code to the imported file code.\
\
\
\
\pard\pardeftab720\partightenfactor0
\cf0 \
\pard\pardeftab720\ri0\partightenfactor0
\cf0 \
\
\
}