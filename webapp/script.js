let validateView = null;

document.addEventListener("DOMContentLoaded", () => {
  const clientForm = document.getElementById("formClient");
  const serviceFrom = document.getElementById("formService");
  const tableClient = document.querySelector("#infoClientTable tbody");
  const searchClient = document.getElementById("search");
  
  let getclient = [];

  if (document.URL.includes("clientForm")) {
    validateView = "clients";
  } else if (document.URL.includes("serviceForm")) {
    validateView = "services";
  } else if (document.URL.includes("consultForm")) {
    validateView = "listClients";
  } else if (document.URL.includes("index")) {
    validateView = "index";
  }

  if (validateView === "clients") {
    if (clientForm) {
      clientForm.addEventListener("submit", async function (event) {
        event.preventDefault();

        const client = {
          nombres: clientForm.elements["nombres"].value,
          apellidos: clientForm.elements["apellidos"].value,
          tipoIdentificacion: clientForm.elements["tipoIdentificacion"].value,
          identificacion: clientForm.elements["identificacion"].value,
          fechaNacimiento: clientForm.elements["fechaNacimiento"].value,
          numeroCelular: clientForm.elements["numeroCelular"].value,
          correoElectronico: clientForm.elements["correoElectronico"].value,
        };
        console.log(client);

        if (validateInfo(client)) {
          alert("Los datos no cumplen con el formato establecido.");
        } else {
          try {
            const response = await fetch(
              "http://localhost:8080/clientes/create",
              {
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                },
                body: JSON.stringify(client),
              }
            );
            if (response.ok) {
              if (response.status === 200) {
                alert("El cliente se ha creado con éxito.");

              }
            } else {
              const errorMessage = await response.text();
              if (response.status === 409) {
                alert(errorMessage);
              } else {
                alert("Error al registrar el cliente");
              }
            }
            resetclienteForm();
          } catch (error) {
            if (
              error.name === "TypeError" &&
              error.message.includes("Failed to fetch")
            ) {
              alert("Error de servicio");
            } else {
              alert("Error: " + error.message);
            }
          }
        }
      });
    }
  }
  if (validateView === "services") {
    if (serviceFrom) {
      serviceFrom.addEventListener("submit", async function (event) {
        event.preventDefault();

        const servicio = {
          identificacion: serviceFrom.elements["identificacionCliente"].value,
          servicio: serviceFrom.elements["servicio"].value,
          fechaInicio: serviceFrom.elements["fechaInicio"].value,
          ultimaFacturacion: serviceFrom.elements["fechaUltima"].value,
          ultimoPago: serviceFrom.elements["ultimoPago"].value,
        };

        if (validateInfo(servicio)) {
          alert("Los datos no cumplen con el formato establecido.");
        } else {
          try {
            const response = await fetch(
              "http://localhost:8080/servicios/create",
              {
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                },
                body: JSON.stringify(servicio),
              }
            );

            if (response.ok) {
              if (response.status === 200) {
                alert("El servicio fue creado con exito");
              }
            } else {
              const errorMessage = await response.text();
              if (response.status === 409) {
                alert(errorMessage);
              } else {
                alert("Error al registrar el servicio");
              }
            }
            resetservicioFrom();
          } catch (error) {
            if (
              error.name === "TypeError" &&
              error.message.includes("Failed to fetch")
            ) {
              alert("Error de servicio");
            } else {
              alert("Error: " + error.message);
            }
          }
        }
      });
    }
  }

  function resetclienteForm() {
    clientForm.elements["nombres"].value = "";
    clientForm.elements["apellidos"].value = "";
    clientForm.elements["tipoIdentificacion"].value = "";
    clientForm.elements["identificacion"].value = "";
    clientForm.elements["fechaNacimiento"].value = "";
    clientForm.elements["numeroCelular"].value = "";
    clientForm.elements["correoElectronico"].value = "";
  }

  function resetservicioFrom() {
    serviceFrom.elements["identificacionCliente"].value = "";
    serviceFrom.elements["servicio"].value = "";
    serviceFrom.elements["fechaInicio"].value = "";
    serviceFrom.elements["fechaUltima"].value = "";
    serviceFrom.elements["ultimoPago"].value = "";
  }

  function validateInfo(data) {
    let identification;
    let telephone;
    let flag = false;

    if (data?.identificacion) {
      identification = data.identificacion;
      if (identification.length < 6 && identification.length > 10) {
        flag = true;
        return flag;
      }
    } else if (data?.numeroCelular) {
      telephone = data.numeroCelular;
      if (telephone.length !== 10) {
        flag = true;
        return flag;
      }
    }

    return flag;
  }
  if (validateView === "listClients") {
    searchClient.addEventListener('click', function (event) {
      event.preventDefault();
      const identificacion = document.getElementById('identificacionConsulta').value;
      if (identificacion.trim() === '') {
        alert('Ingrese un identificador');
        return;
      }
      fetchClients(identificacion);
    });
    async function fetchClients(identificacion) {
      try {
        const response = await fetch(`http://localhost:8080/clientes/consult/${identificacion}`,
          { method: "GET" }
        );
        if (!response.ok) {
          throw new Error("Servicio responde OK");
        }
      
        getclient = await response.json();
         populateTable(getclient);
      } catch (error) {
        console.error("Error al buscar el cliente:", error);
      }
    }


    function populateTable(data) {
    
      tableClient.innerHTML = "";
      
        const row = document.createElement("tr");
        row.innerHTML = `
                    <td>${data.nombres}</td>
                    <td>${data.apellidos}</td>
                    <td>${data.tipoIdentificacion}</td>
                    <td>${data.identificacion}</td>
                    <td>${data.fechaNacimiento}</td>
                    <td>${data.numeroCelular}</td>
                    <td>${data.correoElectronico}</td> 
                   
                    <td><button class="btn-delete">Eliminar</button></td>   
                    <td><button class="btn-update">Actualizar</button></td>            
                `;
        tableClient.appendChild(row);
      };
    


    tableClient.addEventListener("click", async (e) => {
      if (e.target.classList.contains("btn-delete")) {
        e.preventDefault();
        const row = e.target.closest("tr");
        const clientId = row.cells[3].textContent.trim();

        try {
          const response = await fetch(`http://localhost:8080/clientes/delete/${clientId}`, {
            method: "DELETE",
          });

          if (!response.ok) {
            alert("Ocurrió un error al eliminar el cliente");
          } else {
            alert("El cliente fue eliminado");
          }

          row.remove();
        } catch (error) {
          alert("Ocurrió un error: " + error);
        }
      }
    });
  }
});