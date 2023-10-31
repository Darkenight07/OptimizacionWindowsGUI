echo Probando
pause

:: Ruta registro

set rutaRegistro="HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Explorer\VisualEffects"
set valor="VisualFXSetting"
set nuevoValor=2 

:: Lee el valor del registro
reg query "%rutaRegistro%" /v "%valor%"

:: Verifica el codigo de error para determinar si el valor existe o no
if %errorlevel%=0 (
	echo Ya estaban desactivados los efectos visuales.
	set /p confirmacionDesactivar=¿Quieres activar los efectos visuales? (s/n): 
	if %confirmacionDesactivar%==s (
		reg delete "%rutaRegistro%" /v "%valor%" /f
		echo Efectos visuales activados
		pause
		goto exit
	) else (
		if %confirmacionDesactivar%==n (
			echo No se va a activar los efectos visuales. Saliendo del programa
			pause
			goto exit
		)
	)
) else (
	reg add "%rutaRegistro%" /v "%valor%" /t REG_DWORD /d %nuevoValor% /f
	echo Efectos visuales desactivados. Reinicio recomendado.
	set /p confirmacionReincio=¿Quieres reiniciar? (s/n):
	if %confirmacionReincio%==s (
		shutdown /r /t 0
	) else (
		if %confirmacionReincio%==n (
			echo El equipo no se reiniciara
			pause
			goto exit
		)
	)
:exit
echo --------------------------
echo - Gracias por utilizar   -
echo -      el programa!      -
echo --------------------------
pause
exit